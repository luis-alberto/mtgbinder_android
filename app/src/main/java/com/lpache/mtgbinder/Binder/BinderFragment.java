package com.lpache.mtgbinder.Binder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.R;

import java.util.ArrayList;

/**
 * Created by luis on 17/07/15.
 */
public class BinderFragment extends Fragment {
    private ArrayList<Binder_Card> listBinderCard;
    private int pageNumber;
    private View view;
    private GridView binderGridView;


    public BinderFragment(ArrayList<Binder_Card> listBinderCard, int pageNumber) {
        this.listBinderCard = listBinderCard;
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(
                R.layout.fragment_binder_gridview, container, false);
        setRetainInstance(true);
        //create binder_gridview
        binderGridView = (GridView) view.findViewById(R.id.binder_gridview);
        binderGridView.setAdapter(new BinderGridViewAdapter(getActivity(),this.listBinderCard, this.pageNumber));
        return view;

    }
}
