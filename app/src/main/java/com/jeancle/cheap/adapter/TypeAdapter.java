package com.jeancle.cheap.adapter;

import android.content.Context;

import com.jeancle.cheap.R;
import com.jeancle.cheap.base.BaseListAdapter;
import com.jeancle.cheap.base.BaseViewHolder;
import com.jeancle.cheap.bean.ClassifyBean;


/**
 * Created by Jeancle
 * on 2017/4/11.
 * 类说明:
 */

public class TypeAdapter<T extends ClassifyBean> extends BaseListAdapter<T> {
    public TypeAdapter(Context context) {
        super(context);
        bindLayout(R.layout.type_item);
    }


    @Override
    protected void convert(BaseViewHolder holder, T t) {
//        holder.setText(R.id.tv_type, t.getName());
//        holder.setImageResource(R.id.iv_classify_pic, t.getResId());
    }

    @Override
    public int getCount() {
        return 60;
    }
}
