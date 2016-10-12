package com.example.administrator.vfstore.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.administrator.vfstore.R;

/**
 * Created by lenovo on 2016/10/5.
 */
public class Search extends FragmentActivity  {
    FragmentManager manager ;
    LinearLayout layout ;
    Fragment f1,f2;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        layout = (LinearLayout) findViewById(R.id.layout_bottom);
        manager= getSupportFragmentManager() ;
        FragmentTransaction transaction = manager.beginTransaction() ;
        f1 = new ClassificationFragment();
        f2 = new SellBrandFragment();

        button1 = (Button) findViewById(R.id.button1)  ;
        button2 = (Button) findViewById(R.id.button2)  ;


        button1.setOnClickListener(new ButtonClickListener());
        button2.setOnClickListener(new ButtonClickListener());

        transaction.add(R.id.fragment_container, f1);
        transaction.commit();
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
