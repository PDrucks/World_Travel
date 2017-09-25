package com.example.patrick.world_travel_test;

import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by Patrick on 23.09.2017.
 */

public class CountryListAdapter extends ArrayAdapter<Country> {
    private Context mContext;
    int mResource;


    public CountryListAdapter(Context context, int resource, ArrayList<Country> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

       @Override
    public View getView(int position, View convertView, ViewGroup parent) {

           setUpImageLoader();

        String countryName = getItem(position).getCountryName();
        String continent = getItem(position).getContinent();
        String imgURL = getItem(position).getImgURL();

           Country country = new Country(imgURL,countryName, continent);

          LayoutInflater inflater = LayoutInflater.from(mContext);
           convertView = inflater.inflate(mResource, parent, false);

           ImageView imageFlag = (ImageView) convertView.findViewById(R.id.imageFlag);
           TextView tvCountryName = (TextView) convertView.findViewById(R.id.tvCountryName);
           TextView tvContinent = (TextView) convertView.findViewById(R.id.tvContinent);

           int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null, mContext.getPackageName());

           ImageLoader imageLoader = ImageLoader.getInstance();
           DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                   .cacheOnDisc(true).resetViewBeforeLoading(true)
                   .showImageForEmptyUri(defaultImage)
                   .showImageOnFail(defaultImage)
                   .showImageOnLoading(defaultImage).build();


           imageLoader.displayImage(imgURL,imageFlag,options);

           tvCountryName.setText(countryName);
           tvContinent.setText(continent);

           return convertView;
    }

        private void setUpImageLoader() {
            // UNIVERSAL IMAGE LOADER SETUP
            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .cacheOnDisc(true).cacheInMemory(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .displayer(new FadeInBitmapDisplayer(300)).build();

            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                    mContext)
                    .defaultDisplayImageOptions(defaultOptions)
                    .memoryCache(new WeakMemoryCache())
                    .discCacheSize(100 * 1024 * 1024).build();

            ImageLoader.getInstance().init(config);
            // END - UNIVERSAL IMAGE LOADER SETUP
        }
}
