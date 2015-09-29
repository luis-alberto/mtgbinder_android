package com.lpache.mtgbinder.Binder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;
import com.lpache.mtgbinder.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by luis on 18/07/15.
 */
public class BinderGridViewAdapter extends BaseAdapter{
    private static final String LIST_BINDERCARDS = "listBinderCards";
    private static final String POSITION = "position";
    private static final String TEXT_CARD = "MIN: %.2f€ | EX: %2f€ | TREND: %2f€ | FOIL: %2f€";

    private Activity activity;
    private ArrayList<Binder_Card> listBinderCard;
    private ArrayList<Binder_Card> listBinderCardItems;
    private int pageNumber;

    public BinderGridViewAdapter(Activity activity, ArrayList<Binder_Card> listBinderCard, int pageNumber) {

        int lastItemPosition = 9*pageNumber;
        int firstItemPosition = lastItemPosition-9;

        this.activity = activity;
        this.listBinderCard = listBinderCard;
        this.pageNumber = pageNumber;
        this.listBinderCardItems = new ArrayList<>();

        if (lastItemPosition>this.listBinderCard.size()) { lastItemPosition = this.listBinderCard.size(); }

        for (int i = firstItemPosition; i < lastItemPosition; i++) {
            this.listBinderCardItems.add(this.listBinderCard.get(i));
        }
    }

    @Override
    public int getCount() {
        if( listBinderCardItems != null){
            return listBinderCardItems.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if( listBinderCardItems != null){
            return listBinderCardItems.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if( listBinderCardItems != null){
            return listBinderCardItems.get(position).getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View grid;
        Binder_Card binderCardTemp;
        Card cardTemp;
        final int realPosition = (this.pageNumber*9)-9+position;

        //binder view.
        if(view==null){
            grid = new View(activity);
            LayoutInflater inflater = (LayoutInflater) this.activity.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid=inflater.inflate(R.layout.grid_card, viewGroup, false);
        }else{
            grid = view;
        }
        //construction of components of view.
        binderCardTemp = this.listBinderCardItems.get(position);
        cardTemp = binderCardTemp.getCard();
        //construction of card image.
        final NetworkImageView imgCard = (NetworkImageView) grid.findViewById(R.id.image_card);
        ImageLoader imageLoader = VolleySingleton.getInstance(this.activity).getImageLoader();
        imgCard.setImageUrl(cardTemp.getUrl_image(), imageLoader);
        imgCard.setOnClickListener(new View.OnClickListener() {
            /**
             * Onclick Image to start BinderCardDetailActivity.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, BinderCardDetailActivity.class);
                intent.putParcelableArrayListExtra(LIST_BINDERCARDS, listBinderCard);
                intent.putExtra(POSITION, realPosition);
                activity.startActivity(intent);
            }

        });
//        TextView textView = (TextView)grid.findViewById(R.id.text_card);
//        textView.setText(String.format(TEXT_CARD, cardTemp.getPrice_low(),cardTemp.getPrice_lowex(),
//                cardTemp.getPrice_trend(),cardTemp.getPrice_lowfoil()));

        return grid;
    }
}
