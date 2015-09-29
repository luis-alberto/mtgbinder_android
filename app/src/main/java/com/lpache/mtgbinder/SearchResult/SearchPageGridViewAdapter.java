package com.lpache.mtgbinder.SearchResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.lpache.mtgbinder.Binder.BinderCardDetailActivity;
import com.lpache.mtgbinder.Entity.Binder_Card;
import com.lpache.mtgbinder.Entity.Card;
import com.lpache.mtgbinder.R;
import com.lpache.mtgbinder.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by luis on 06/08/15.
 */
public class SearchPageGridViewAdapter extends BaseAdapter {
    private static final String LIST_BINDERCARDS = "listBinderCards";
    private static final String POSITION = "position";
    private static final String TEXT_CARD = "MIN: %.2f€ | EX: %.2f€ | TREND: %.2f€ | FOIL: %.2f€";

    private Activity activity;
    private ArrayList<Card> listCard;
    private ArrayList<Card> listCardItems;
    private int pageNumber;

    public SearchPageGridViewAdapter(Activity activity, ArrayList<Card> listCard, int pageNumber) {

        int lastItemPosition = 9*(pageNumber+1);
        int firstItemPosition = lastItemPosition-9;

        this.activity = activity;
        this.listCard = listCard;
        this.pageNumber = pageNumber;
        this.listCardItems = new ArrayList<>();

        if (lastItemPosition>this.listCard.size()) { lastItemPosition = this.listCard.size(); }

        for (int i = firstItemPosition; i < lastItemPosition; i++) {
            this.listCardItems.add(this.listCard.get(i));
        }
    }

    @Override
    public int getCount() {
        if( listCardItems != null){
            return listCardItems.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if( listCardItems != null){
            return listCardItems.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if( listCardItems != null){
            return listCardItems.get(position).getIdProduct();
        }
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View grid;

//        Card binderCardTemp;
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
//        grid.setMinimumWidth(activity.getWindow().getDecorView().getMeasuredWidth()/3);
        WindowManager wm = activity.getWindowManager();
        Display disp = wm.getDefaultDisplay();
        int orientation = disp.getRotation();
        int heigthCell;
        int widthCell;
        if(orientation==0){
            heigthCell=activity.getWindow().getDecorView().getMeasuredHeight() / 3;
            widthCell = heigthCell* 4/5;
        }else{
            widthCell=activity.getWindow().getDecorView().getMeasuredHeight() / 3;
            heigthCell = widthCell* 4/5;
        }
        //construction of components of view.
//        binderCardTemp = this.listCardItems.get(position);
//        cardTemp = binderCardTemp.getCard();
        cardTemp = this.listCardItems.get(position);
        //construction of card image.
        final NetworkImageView imgCard = (NetworkImageView) grid.findViewById(R.id.image_card);
        ImageLoader imageLoader = VolleySingleton.getInstance(this.activity).getImageLoader();
        imgCard.setImageUrl(cardTemp.getUrl_image(), imageLoader);
        imgCard.setDefaultImageResId(R.drawable.cardback);
        imgCard.setMinimumWidth(heigthCell);
        activity.getRequestedOrientation();

        imgCard.setMinimumHeight(widthCell);
        imgCard.setOnClickListener(new View.OnClickListener() {
            /**
             * Onclick Image to start BinderCardDetailActivity.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, BinderCardDetailActivity.class);
                intent.putParcelableArrayListExtra(LIST_BINDERCARDS, listCard);
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

