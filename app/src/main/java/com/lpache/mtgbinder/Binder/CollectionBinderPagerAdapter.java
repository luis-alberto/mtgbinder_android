package com.lpache.mtgbinder.Binder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lpache.mtgbinder.Entity.Binder;

import java.util.ArrayList;

/**
 * Created by luis on 16/07/15.
 */
public class CollectionBinderPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Binder> listBinders;


    public CollectionBinderPagerAdapter(FragmentManager fragmentManager,ArrayList<Binder> listBinders) {
        super(fragmentManager);
        this.listBinders = listBinders;
    }

    @Override
    public Fragment getItem(int position) {
        if(!this.listBinders.isEmpty()){
            return new CollectionBinderFragment(this.listBinders.get(position));
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.listBinders.size();
    }
}
