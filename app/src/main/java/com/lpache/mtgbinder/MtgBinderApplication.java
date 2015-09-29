package com.lpache.mtgbinder;

import android.app.Application;
import android.os.Parcel;

import com.lpache.mtgbinder.Entity.Binder;
import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.Entity.Language;
import com.lpache.mtgbinder.Entity.Quality;
import com.lpache.mtgbinder.mkmApi.MkmApi_Cards;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by luis on 17/07/15.
 */
public class MtgBinderApplication extends Application {
    public ArrayList<Binder> listBinders = new ArrayList<>();
    public ArrayList<Binder_Card> listBinderCards = new ArrayList<>();
    public ArrayList<Card> listCards = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        remplirDonnésBidonTest();
    }

    /**
     * A EFFACER DONNES BIDONS
     */
    public void remplirDonnésBidonTest(){
        //BINDERS
        Binder binder = new Binder();
        String name;
        for (int i = 1; i < 4; i++) {
            binder.setIdBinder(i);
            name = String.format("Binder%d",i);
            binder.setNameBinder(name);
            listBinders.add(binder);
        }

        //CARDS
        MkmApi_Cards mkmapi_test = new MkmApi_Cards(this,"https://www.mkmapi.eu/ws/v1.1/output.json/products/akroma/1/2/false");
        mkmapi_test.execute();
        try {
            listCards = mkmapi_test.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (Card c: listCards) {
            c.getPrice_lowex();
        }

        //BINDER_CARDS
        Binder_Card binderCard = new Binder_Card() {
            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {

            }
        };
        binderCard.setLanguage(Language.French);
        binderCard.setQuality(Quality.NM);
        binderCard.setQuantity(5);
        int index = 1;
        for(Binder binderTemp: listBinders){
            for(Card cardTemps: listCards){
                binderCard.setBinder(binderTemp);
                binderCard.setCard(cardTemps);
                binderCard.setId(index);
                listBinderCards.add(binderCard);
                index++;
            }
        }
    }
}
