package com.huangxueqin.hqpullrefreshlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huangxueqin.hqpullrefreshlayout.HQPullRefreshLayout;

public class MainActivity extends AppCompatActivity {

    HQPullRefreshLayout mPullRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullRefreshLayout = (HQPullRefreshLayout) findViewById(R.id.pullRefreshLayout);
        mPullRefreshLayout.setOnRefreshListener(new HQPullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullRefreshLayout.stopRefresh(true);
                    }
                }, 5000);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
