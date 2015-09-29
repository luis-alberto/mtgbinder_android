package com.lpache.mtgbinder.SearchResult;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lpache.mtgbinder.Binder.BinderGridViewAdapter;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;

import java.util.ArrayList;

/**
 * Created by luis on 06/08/15.
 */
public class SearchPageFragment extends Fragment{
    private ArrayList<Card> listCard;
    private int pageNumber;
    private View view;
    private GridView binderGridView;


    public SearchPageFragment(ArrayList<Card> listCard, int pageNumber) {
        this.listCard = listCard;
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(
                R.layout.fragment_binder_gridview, container, false);
        setRetainInstance(true);
        //create binder_gridview
        binderGridView = (GridView) view.findViewById(R.id.binder_gridview);

        binderGridView.setAdapter(new SearchPageGridViewAdapter(getActivity(),this.listCard, this.pageNumber));
        return view;

    }
}
