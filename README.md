# RecyclerviewTest
自定义的一个RecycleView，实现了ListView、GridView和瀑布流三种效果，并且实现了点击效果（包括点击和长点击事件），内容不是特别复杂，关键点也都加了注释。

入口在MainActivity中，可以在这里更改你想要的样式：

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
