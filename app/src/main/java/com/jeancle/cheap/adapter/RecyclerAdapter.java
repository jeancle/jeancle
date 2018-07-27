package com.jeancle.cheap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jeancle.cheap.R;
import com.jeancle.cheap.bean.GoodsBean;
import com.jeancle.cheap.bean.TicketsBean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/22.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> data;
    Context context;
    OnItemClickListener mOnItemClickListener;
    public void setData(List<TicketsBean.TbkDgItemCouponGetResponseBean.ResultsBean.TbkCouponBean> data) {
        this.data = data;
    }

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    //加载item 的布局  创建ViewHolder实例
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jiukuaijiu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    //对RecyclerView子项数据进行赋值
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).asBitmap().load(data.get(position).getPict_url()).into(holder.id_good_img);
        holder.tv_good_title.setText(data.get(position).getTitle());
        holder.tv_now_price.setText(Double.parseDouble(data.get(position).getZk_final_price()) - Double.parseDouble(data.get(position).getCommission_rate()) + "");
        holder.tv_old_price.setText(data.get(position).getZk_final_price());
        holder.tv_ticket.setText(data.get(position).getCommission_rate());
        holder.tv_sale_count.setText(data.get(position).getVolume());
//        holder.tv_place.setText(data.get(position).get);
        if( mOnItemClickListener!= null){
            holder. itemView.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });

            holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }

    }

    //返回子项个数
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView id_good_img;
        TextView tv_good_title;
        TextView tv_now_price;
        TextView tv_old_price;
        TextView tv_ticket;
        TextView tv_sale_count;
        TextView tv_place;

        public ViewHolder(View view) {
            super(view);
            id_good_img = (ImageView) view.findViewById(R.id.id_good_img);
            tv_good_title = (TextView) view.findViewById(R.id.tv_good_title);
            tv_now_price = (TextView) view.findViewById(R.id.tv_now_price);
            tv_old_price = (TextView) view.findViewById(R.id.tv_old_price);
            tv_ticket = (TextView) view.findViewById(R.id.tv_ticket);
            tv_sale_count = (TextView) view.findViewById(R.id.tv_sale_count);
            tv_place = (TextView) view.findViewById(R.id.tv_place);
        }
    }
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }

}
