package com.jeancle.cheap.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jeancle
 * on 2017/4/11.
 * 类说明:
 */

public class BaseViewHolder {
    private SparseArray<View> mViews;
    protected View convertView;
    protected int position;
    protected Context context;


    protected BaseViewHolder(Context context, ViewGroup parent, int layoutID, int position) {
        this.context = context;
        this.position = position;
        this.mViews = new SparseArray<>();
        this.convertView = LayoutInflater.from(parent.getContext()).inflate(layoutID, parent, false);
        this.convertView.setTag(this);
    }

    /**
     * 得到一个holder
     */
    public static BaseViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new BaseViewHolder(context, parent, layoutId, position);
        } else {
            BaseViewHolder holder = (BaseViewHolder) convertView.getTag();
            return holder;
        }
    }

    /**
     * 通过id初始化控件
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return convertView;
    }
    //****************************功能区 设置数据**********************************

    /**
     * 给TextView设值
     */
    public BaseViewHolder setText(int resId, String text) {
        TextView tv = getView(resId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
//            }
//        });
        return this;
    }

    /**
     * 给ImageView设Bitmap
     */
    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        if (bitmap!=null) {
            iv.setImageBitmap(bitmap);
        }
        return this;
    }

}
