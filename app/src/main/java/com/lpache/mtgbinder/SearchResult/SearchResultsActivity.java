package com.lpache.mtgbinder.SearchResult;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;
import com.lpache.mtgbinder.mkmApi.MkmApi_Cards;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by luis on 05/08/15.
 */
public class SearchResultsActivity extends ActionBarActivity{
    private boolean result;
    private ArrayList<Card> listCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        handleIntent(getIntent());
        if(result){

            setContentView(R.layout.activity_search);
            ViewPager viewPager = (ViewPager) findViewById(R.id.search_result_pager);
            SearchResultsPagerAdapter searchResultsPagerAdapter =
                    new SearchResultsPagerAdapter(getSupportFragmentManager(),listCards);
            viewPager.setAdapter(searchResultsPagerAdapter);
        }else{
            setContentView(R.layout.fragment_search_empty);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search
            String url = "https://www.mkmapi.eu/ws/v1.1/output.json/products/"+query.replace(" ","_")+"/1/2/false";
            MkmApi_Cards mkmapi_test = new MkmApi_Cards(this,url);
            mkmapi_test.execute();
            listCards = new ArrayList<>();
            try {
                listCards = mkmapi_test.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if(listCards.size()==0){ result = false;}
            else{result=true;}
//            TextView mTextView = (TextView) findViewById(R.id.result);
//            mTextView.setText(listCards.toString());
//            result = true;
        }
        else
        {
            result=false;
        }
    }
}
