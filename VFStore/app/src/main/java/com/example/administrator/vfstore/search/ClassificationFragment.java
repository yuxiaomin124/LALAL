package com.example.administrator.vfstore.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.vfstore.R;

/**
 * Created by lenovo on 2016/10/6.
 */
public class ClassificationFragment extends android.support.v4.app.Fragment {

    FragmentManager manager ;
    LinearLayout layout ;
    Fragment f1,f2;
    Button button1,button2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classification_fragment, null);

        manager= getChildFragmentManager() ;
        FragmentTransaction transaction = manager.beginTransaction() ;
        f1 = new WomenFragment();
        f2 = new MenFragment();

        button1 = (Button) view.findViewById(R.id.button1)  ;
        button2 = (Button) view.findViewById(R.id.button2)  ;


        button1.setOnClickListener(new ButtonClickListener());
        button2.setOnClickListener(new ButtonClickListener());

        transaction.add(R.id.fragment_container, f1);
        transaction.commit();
        return view;
    }
    class ButtonClickListener implements View.OnClickListener {
        FragmentTransaction transaction ;
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button1:{
                    v.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed));
                    button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.update_device_image_background));

                    transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment_container,f1);
                    transaction.commit();
                    break;
                }
                case R.id.button2:{
                    v.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed));
                    button1.setBackgroundDrawable(getResources().getDrawable(R.drawable.update_device_image_background));

                    transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment_container,f2);
                    transaction.commit();
                    break;
                }

                default:{

                    transaction.replace(R.id.fragment_container,f1);
                    transaction.commit();
                    break;

                }
            }
        }
    }
}
