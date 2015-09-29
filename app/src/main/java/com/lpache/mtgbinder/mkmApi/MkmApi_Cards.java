package com.lpache.mtgbinder.mkmApi;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.Entity.Language;
import com.lpache.mtgbinder.MainActivity;
import com.lpache.mtgbinder.MtgBinderApplication;
import com.lpache.mtgbinder.R;
import com.lpache.mtgbinder.mkmApi.MkmApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by luis on 09/07/15.
 */
public class MkmApi_Cards extends AsyncTask<String, ArrayList<Card>, ArrayList<Card>>{
    private final Context context;
    private String url;

    ProgressDialog progressDialog;

    public MkmApi_Cards(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Searching!!");
    }

    protected ArrayList<Card> doInBackground(String... params) {
        JSONObject json;
        ArrayList<Card> list_cards = new ArrayList<>();
        String mkmAppToken = "hsTNupGi2LoupAFo" ;
        String mkmAppSecret = "kbY6sCv9NYSe2t6fjn1uCi7wFqRskn0A" ;
        String mkmAccessToken = "" ;
        String mkmAccessTokenSecret = "" ;


        MkmApi mkmApiTest = new MkmApi(mkmAppToken, mkmAppSecret, mkmAccessToken, mkmAccessTokenSecret);
//        mkmApiTest.request("https://www.mkmapi.eu/ws/v1.1/output.json/product/271530");
//        mkmApiTest.request("https://www.mkmapi.eu/ws/v1.1/products/ile/1/1/false");
//        mkmApiTest.request("https://www.mkmapi.eu/ws/v1.1/img/cards/Modern_Masters_2015/izzet_boilerworks.jpg");
//        mkmApiTest.request("https://www.mkmapi.eu/ws/v1.1/metaproduct/210746");
//        mkmApiTest.request("https://www.mkmapi.eu/ws/v1.1/products/akroma/1/1/false");
        mkmApiTest.request(url);
        json = mkmApiTest.responseContent();

        try {
            JSONArray jsonArray = json.getJSONArray("product");
            for (int i = 0; i < jsonArray.length(); i++) {
                list_cards.add(JSONObjectToCard(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                JSONObject jsonObj = json.getJSONObject("product");
                list_cards.add(JSONObjectToCard(jsonObj));
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
        return list_cards;
    }

    @Override
    protected void onPostExecute(ArrayList<Card> cards) {
        super.onPostExecute(cards);
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private Card JSONObjectToCard(JSONObject json){
        int idProduct;
        String name_1= "", name_2= "", name_3= "",name_4= "", name_5= "";
        String url_image= "";
        String url_website ="";
        double price_low;
        double price_lowex;
        double price_trend;
        double price_lowfoil;

        try {
            idProduct = json.getInt("idProduct");
            JSONObject jsonObj_product_name = json.getJSONObject("name");
            try {
                name_1 = new String(jsonObj_product_name.getJSONObject("1").getString("productName").getBytes(), "UTF-8");
                name_2 = new String(jsonObj_product_name.getJSONObject("2").getString("productName").getBytes(), "UTF-8");
                name_3 = new String(jsonObj_product_name.getJSONObject("3").getString("productName").getBytes(), "UTF-8");
                name_4 = new String(jsonObj_product_name.getJSONObject("4").getString("productName").getBytes(), "UTF-8");
                name_5 = new String(jsonObj_product_name.getJSONObject("5").getString("productName").getBytes(), "UTF-8");
                url_image = new String(json.getString("image").getBytes(), "UTF-8");
                url_website = new String(json.getString("website").getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            JSONObject jsonObj_product_price = json.getJSONObject("priceGuide");
            price_low = jsonObj_product_price.getDouble("LOW");
            price_lowex = jsonObj_product_price.getDouble("LOWEX");
            price_trend = jsonObj_product_price.getDouble("TREND");
            price_lowfoil = jsonObj_product_price.getDouble("LOWFOIL");

            Card card = new Card();
            card.setIdProduct(idProduct);
            card.setName_1(name_1);
            card.setName_2(name_2);
            card.setName_3(name_3);
            card.setName_4(name_4);
            card.setName_5(name_5);
            card.setUrl_image(url_image);
            card.setUrl_website(url_website);
            card.setPrice_low(price_low);
            card.setPrice_lowex(price_lowex);
            card.setPrice_trend(price_trend);
            card.setPrice_lowfoil(price_lowfoil);

            return card;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
