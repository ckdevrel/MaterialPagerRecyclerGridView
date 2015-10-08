package com.takeoffandroid.materialpagerrecyclergridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.takeoffandroid.materialpagerrecyclergridview.adapters.HomeAdapter;
import com.takeoffandroid.materialpagerrecyclergridview.views.GridMarginDecoration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        setSupportActionBar(toolbar);


        final HomeAdapter adapter = new HomeAdapter(this, R.array.icons);

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

}
