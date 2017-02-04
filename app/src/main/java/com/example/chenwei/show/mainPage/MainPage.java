package com.example.chenwei.show.mainPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.chenwei.show.R;

/**
 * Created by chenwei on 17/2/3.
 */

public class MainPage extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

    }
}
