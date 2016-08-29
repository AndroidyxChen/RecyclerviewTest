package com.example.chen.apptestone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chen on 2016-3-15.
 */
class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    //private List<String> mList;
    private LayoutInflater mInflater;

    private String[] mGvTitles;
    private int[] mGvIcons;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


   /* public HomeAdapter(Context context, List<String> list) {
        mInflater = LayoutInflater.from(context);//思考
        mList = list;
    }*/

    public HomeAdapter(Context context, String[] GvTitles, int[] GvIcons) {
        mInflater = LayoutInflater.from(context);//思考
        mGvTitles = GvTitles;
        mGvIcons = GvIcons;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_home, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(mGvTitles[position]);
        holder.iv.setImageResource(mGvIcons[position]);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    //addData(pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    //removeData(pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mGvTitles.length;
    }

   /* //添加数据
    public void addData(int position) {
        mList.add(position, "Insert One");
        notifyItemInserted(position);
    }

    //删除数据
    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }*/

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            iv = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }
}
