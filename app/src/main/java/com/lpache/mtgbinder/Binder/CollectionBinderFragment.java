package com.lpache.mtgbinder.Binder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lpache.mtgbinder.Entity.Binder;
import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.MtgBinderApplication;
import com.lpache.mtgbinder.R;

import java.util.ArrayList;

/**
 * Created by luis on 16/07/15.
 */
public class CollectionBinderFragment extends Fragment {
    private ArrayList<Binder_Card> listBinderCards = new ArrayList<>();
    private View view;
    private ViewPager binderPager;


    private MtgBinderApplication globalVariable;
    ArrayList<Binder_Card> listBinderCardsTemp;

    public CollectionBinderFragment(Binder binder) {
//        this.globalVariable = (MtgBinderApplication) getActivity().getApplication();
//        this.listBinderCardsTemp = globalVariable.listBinderCards;
//        for (Binder_Card binderCard: listBinderCardsTemp) {
//            if(binderCard.getBinder().equals(binder)){
//                listBinderCards.add(binderCard);
//            }
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(listBinderCards.size()!=0) {
            //View for a binder with cards
            view = inflater.inflate(R.layout.fragment_binder, container, false);
            setRetainInstance(true);
            //create and binder pager.
            binderPager = (ViewPager) view.findViewById(R.id.binder_pager);
            binderPager.setAdapter(new BinderPagerAdapter(getFragmentManager(), listBinderCards));
        }else{
            //View for an empty binder
            view = inflater.inflate(R.layout.fragement_binder_empty, container, false);
            setRetainInstance(true);
        }
        return view;

    }
}
