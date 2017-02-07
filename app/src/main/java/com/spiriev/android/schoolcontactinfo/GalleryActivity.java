package com.spiriev.android.schoolcontactinfo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by h3moglob1n on 1/31/17.
 */
public class GalleryActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CustomSwipeAdapter adapter;

    /**
     * Sets the content view, swipe adapter and current item for the gallery activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        int position = getIntent().getIntExtra("POSITION_KEY", 0);
        viewPager = (ViewPager) findViewById(R.id.gallery_id);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
