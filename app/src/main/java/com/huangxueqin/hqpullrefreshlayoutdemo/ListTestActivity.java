package com.huangxueqin.hqpullrefreshlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huangxueqin on 2017/7/17.
 */

public class ListTestActivity extends AppCompatActivity {
    RecyclerView mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);

        mList = (RecyclerView) findViewById(R.id.list);
        mList.setAdapter(new SimpleAdapter());
    }

    private class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapterHolder> {

        @Override
        public SimpleAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ListTestActivity.this);
            return new SimpleAdapterHolder(inflater.inflate(R.layout.view_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(SimpleAdapterHolder holder, int position) {
            holder.title.setText("这是第" + position + "行");
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }

    private static class SimpleAdapterHolder extends RecyclerView.ViewHolder {
        TextView title;

        public SimpleAdapterHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
