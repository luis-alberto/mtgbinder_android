package com.lpache.mtgbinder.Binder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lpache.mtgbinder.Entity.Binder_Card;

import java.util.ArrayList;

/**
 * Created by luis on 17/07/15.
 */
public class BinderPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Binder_Card> listBinderCards;

    public BinderPagerAdapter(FragmentManager fm, ArrayList<Binder_Card> listBinderCards) {
        super(fm);
        this.listBinderCards = listBinderCards;
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

        if(!this.listBinderCards.isEmpty()){
            return new BinderFragment(this.listBinderCards, position);
        }
        return null;
    }

    @Override
    public int getCount() {
        int nbItems = this.listBinderCards.size();
        int nbPages = nbItems/9;
        if (nbItems%9!=0){ nbPages++; }
        return nbPages;
    }
}


