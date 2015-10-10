package com.takeoffandroid.materialpagerrecyclergridview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.takeoffandroid.materialpagerrecyclergridview.R;
import com.takeoffandroid.materialpagerrecyclergridview.adapters.MainAdapter;
import com.takeoffandroid.materialpagerrecyclergridview.listeners.OnGridItemSelectedListener;
import com.takeoffandroid.materialpagerrecyclergridview.listeners.OnPageItemSelectedListener;
import com.takeoffandroid.materialpagerrecyclergridview.views.GridMarginDecoration;

public class MainActivity extends AppCompatActivity implements OnPageItemSelectedListener, OnGridItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        setSupportActionBar(toolbar);


        final MainAdapter adapter = new MainAdapter(this, R.array.icons);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isPositionHeader(position) ? layoutManager.getSpanCount() : 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridMarginDecoration(this, 2, 2, 2, 2));

        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onGridItemClick(View v, int position) {
        Toast.makeText(MainActivity.this, "Grid item clicked position is " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPagerItemClick(View view, int position) {
        Toast.makeText(MainActivity.this,"Pager item clicked position is "+position,Toast.LENGTH_SHORT).show();

    }
}
