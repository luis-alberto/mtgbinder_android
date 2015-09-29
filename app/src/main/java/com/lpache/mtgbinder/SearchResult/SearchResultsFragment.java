package com.lpache.mtgbinder.SearchResult;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;

import java.util.ArrayList;

/**
 * Created by luis on 06/08/15.
 */
public class SearchResultsFragment extends Fragment {
    private ArrayList<Card> listCards = new ArrayList<>();
    private GridView binderGridView;
    private int pageNumber;
    private View view;

    public SearchResultsFragment(ArrayList<Card> listCards, int pageNumber) {
        this.listCards = listCards;
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(listCards.size()!=0) {
            //View for a page with cards
            this.view = inflater.inflate(R.layout.fragment_binder_gridview, container, false);
            setRetainInstance(true);
            //create gridview.
            this.binderGridView = (GridView) view.findViewById(R.id.binder_gridview);
            this.binderGridView.setAdapter(new SearchPageGridViewAdapter(getActivity(), this.listCards, this.pageNumber));
        }else{
            //View for an empty binder
            this.view = inflater.inflate(R.layout.fragment_search_empty, container, false);
            setRetainInstance(true);
        }
        return this.view;

    }
}
