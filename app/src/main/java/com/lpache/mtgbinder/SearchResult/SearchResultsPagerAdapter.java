package com.lpache.mtgbinder.SearchResult;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lpache.mtgbinder.Binder.BinderFragment;
import com.lpache.mtgbinder.Entity.Card;

import java.util.ArrayList;

/**
 * Created by luis on 06/08/15.
 */
public class SearchResultsPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Card> listCards;

    public SearchResultsPagerAdapter(FragmentManager fm, ArrayList<Card> listCards) {
        super(fm);
        this.listCards = listCards;
    }

    @Override
    public Fragment getItem(int position) {
//        ArrayList<Binder_Card> listBinderCardItems = new ArrayList<>();
//        int lastItemPosition = 9*position;
//        int firstItemPosition = lastItemPosition-9;
//
//        if (lastItemPosition>this.nbItems) { lastItemPosition = this.nbItems; }
//
//        for (int i = firstItemPosition; i < lastItemPosition; i++) {
//            listBinderCardItems.add(this.listBinderCards.get(i));
//        }

        if(!this.listCards.isEmpty()){
            return new SearchResultsFragment(this.listCards, position);
        }
        return null;
    }

    @Override
    public int getCount() {
        int nbItems = this.listCards.size();
        int nbPages = nbItems/9;
        if (nbItems%9!=0){ nbPages++; }
        return nbPages;
    }
}
