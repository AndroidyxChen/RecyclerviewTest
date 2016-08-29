package com.example.chen.apptestone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list;
    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    private String[] mGvTitles;
    private int[] mGvIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recyclerview);
        initData();
        init();
    }

    private void initData() {
        mGvTitles = new String[]{"手机充值","水费","电费","燃气费","天气","商城","家政","打车","酒店"};
        mGvIcons = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    }

    private void init() {
//        list = new ArrayList();
//        for (int i = 1; i < 200; i++) {
//            list.add(i + "");
//        }
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        /**
         * RecyclerView.LayoutManager，这是一个抽象类，系统提供了3个实现类：
         * LinearLayoutManager 线形管理器，支持横向、纵向
         * GridLayoutManager 网格布局管理器
         * StaggeredGridLayoutManager 瀑布流式布局管理器
         */
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//线式（ListView）
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));//网格式（GridView）
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));//瀑布流式
//        mAdapter = new HomeAdapter(this, list);
        mAdapter=new HomeAdapter(this,mGvTitles,mGvIcons);
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));//给RecyclerView添加分割线(线式时)
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));//给RecyclerView添加分割线(网格式时)
        initEvent();
    }
    private void initEvent()
    {
        mAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}