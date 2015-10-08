package com.takeoffandroid.materialpagerrecyclergridview.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.takeoffandroid.materialpagerrecyclergridview.R;
import com.takeoffandroid.materialpagerrecyclergridview.views.CirclePageIndicator;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final int mImageResID;

    private Context mContext;

    public HomeAdapter(Context context, int imageResID) {
        this.mImageResID = imageResID;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate (R.layout.include_view_pager, parent, false);
            return new HeaderViewHolder (v);
            
        } else if(viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home, null);
            return new RecyclerViewHolder(view);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.viewPager.setAdapter(new ViewPagerAdapter(mContext, R.array.icons));
            headerHolder.mIndicator.setViewPager(headerHolder.viewPager);

        } else if(holder instanceof RecyclerViewHolder) {
            RecyclerViewHolder genericViewHolder = (RecyclerViewHolder) holder;

            Drawable icon = mContext.getResources().obtainTypedArray(mImageResID).getDrawable(position-1);

            genericViewHolder.image.setImageDrawable(icon);

        }

    }

    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    public boolean isPositionHeader(int position) {
        return position == 0;
    }


    @Override
    public int getItemCount() {
        return (mContext.getResources().getIntArray(mImageResID).length)+1;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;
        CirclePageIndicator mIndicator;

        public HeaderViewHolder (View itemView) {
            super (itemView);
            this.viewPager = (ViewPager) itemView.findViewById(R.id.pager);
            this.mIndicator  = (CirclePageIndicator) itemView.findViewById(R.id.indicator);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView image;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //implementing onClickListener
            itemView.setOnClickListener(this);
            image = (ImageView)itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {
            //Every time you click on the row toast is displayed
        }
    }
}
