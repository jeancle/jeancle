package com.jeancle.cheap.fragment.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeancle.cheap.R;

/**
 * Created by Jeancle
 * on 2017/4/7.
 * 类说明:
 */

public class PageOneFrament extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.welcome_content, null);

        ImageView page = (ImageView) layout.findViewById(R.id.iv_page);
        TextView start = (TextView) layout.findViewById(R.id.tv_start);
        start.setVisibility(View.GONE);
        page.setImageDrawable(getResources().getDrawable(R.drawable.welcome1));
        return layout;
    }
}
