package com.example.administrator.vfstore.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.vfstore.R;

/**
 * Created by lenovo on 2016/10/7.
 */
public class WomenFragment extends android.support.v4.app.Fragment {
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.women_fragment, null);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(),SoreDetails.class);
                startActivity(it);
            }
        });
        return view;

    }
}