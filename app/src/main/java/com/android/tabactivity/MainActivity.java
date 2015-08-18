package com.android.tabactivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    /** Called when the activity is first created. */

    OnSwipeTouchListener onSwipeTouchListener;
    TabHost tabHost;
    TabHost.TabSpec spec; // Reusable TabSpec for each tab
    Intent intent; // Reusable Intent for each tab
    Integer tabsNum=3;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        onSwipeTouchListener.getGestureDetector().onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Resources res = getResources(); // Resource object to get Drawables
        tabHost = getTabHost(); // The activity TabHost


        // Create an Intent to launch an Activity for the tab (to be reused)
        initTabs();


        //set tab which one you want open first time 0 or 1 or 2
        tabHost.setCurrentTab(0);


        onSwipeTouchListener = new OnSwipeTouchListener() {
            /*public boolean onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
                return true;
            }*/

            public boolean onSwipeRight() {
                if(tabHost.getCurrentTab()<tabsNum-1){tabHost.setCurrentTab(tabHost.getCurrentTab()+1);}
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onSwipeLeft() {
                if(tabHost.getCurrentTab()>0){tabHost.setCurrentTab(tabHost.getCurrentTab()-1);}
                //Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                return true;
            }
            /*public boolean onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                return true;
            }*/
        };

        tabHost.setOnTouchListener(onSwipeTouchListener);
    }

    public void initTabs() {
        intent = new Intent().setClass(this, OneActivity.class);
        spec = tabHost.newTabSpec("one")
                .setIndicator("ONE")
                .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        intent = new Intent().setClass(this, TwoActivity.class);
        spec = tabHost.newTabSpec("two")
                .setIndicator("TWO")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ThreeActivity.class);
        spec = tabHost.newTabSpec("three")
                .setIndicator("THREE")
                .setContent(intent);
        tabHost.addTab(spec);
    }

}





