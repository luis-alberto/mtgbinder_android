package com.lpache.mtgbinder;

import android.app.Application;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.lpache.mtgbinder.Binder.CollectionBinderPagerAdapter;
import com.lpache.mtgbinder.Entity.Binder;
import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;
import com.lpache.mtgbinder.mkmApi.MkmApi_Cards;

import java.util.ArrayList;

import static com.lpache.mtgbinder.volley.VolleySingleton.*;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MtgBinderApplication globalVariable = (MtgBinderApplication) getApplicationContext();
        ArrayList<Binder> listBinders = globalVariable.listBinders;
        ArrayList<Card> listCards = globalVariable.listCards;
        ArrayList<Binder_Card> listBinderCards = globalVariable.listBinderCards;



        setContentView(R.layout.activity_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.collection_binder_pager);
        CollectionBinderPagerAdapter collectionBinderPagerAdapter =
                new CollectionBinderPagerAdapter(getSupportFragmentManager(),listBinders);
        viewPager.setAdapter(collectionBinderPagerAdapter);

        //---------------------------------------------------------------------------------
//        RequestQueue queue = getInstance(this).getRequestQueue();
//
//
//        final TextView mTextView = (TextView) findViewById(R.id.txt_example);
//        String url ="http://api.mtgdb.info/cards/types";

//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        mTextView.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("That didn't work!");
//            }
//        });
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);

//        MkmApi_Cards mkmapi_test = new MkmApi_Cards(this);
//        mkmapi_test.execute();
//
//        String IMAGE_URL =
//                "http://www.mkmapi.eu/./img/cards/Modern_Masters_2015/izzet_boilerworks.jpg";

//        final NetworkImageView img_test = (NetworkImageView) findViewById(R.id.icon_test);
//        ImageLoader imageLoader = getInstance(this).getImageLoader();
//        img_test.setImageUrl(IMAGE_URL, imageLoader);


        //---------------------------------------------------------------------------------
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;


        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
