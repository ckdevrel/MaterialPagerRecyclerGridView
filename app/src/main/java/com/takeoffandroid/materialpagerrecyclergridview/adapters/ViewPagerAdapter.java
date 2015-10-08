package com.takeoffandroid.materialpagerrecyclergridview.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.takeoffandroid.materialpagerrecyclergridview.R;


public class ViewPagerAdapter extends PagerAdapter {

        private int iconResId;
        public static Context mContext;

        public ViewPagerAdapter(Context context, int iconResId) {

            this.iconResId = iconResId;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mContext.getResources().getIntArray(iconResId).length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Drawable icon = mContext.getResources().obtainTypedArray(iconResId).getDrawable(position);

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            View itemView = inflater.inflate(R.layout.viewpager_item, container, false);


            ImageView iconView = (ImageView) itemView.findViewById(R.id.landing_img_slide);


            iconView.setImageDrawable(icon);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);

        }
    }