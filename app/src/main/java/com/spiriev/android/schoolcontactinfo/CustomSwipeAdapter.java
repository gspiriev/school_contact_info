package com.spiriev.android.schoolcontactinfo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by h3moglob1n on 1/31/17.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] imageResources = {R.drawable.dobri_hristov_national_art_school_1, R.drawable.dobri_hristov_national_art_school_2,
            R.drawable.dobri_hristov_national_art_school_3, R.drawable.dobri_hristov_national_art_school_4,
            R.drawable.dobri_hristov_national_art_school_5};
    private LayoutInflater inflater;
    private Context ctx;

    public CustomSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * Checks if the page view is associated with the object returned from
     * instantiateItem(ViewGroup container, int position)
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    /**
     * Inflates the swipe adapter layout, sets image resource and adds the
     * inflated view to the ViewGroup
     *
     * @param container
     * @param position  Position from which the image rendering should happen
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = inflater.inflate(R.layout.swipe_adapter_layout, container, false);
        ImageView image_view = (ImageView) item_view.findViewById(R.id.image_view_id);
        image_view.setImageResource(imageResources[position]);
        container.addView(item_view);
        return item_view;
    }

    /**
     * Removes current view when sliding to the next one
     *
     * @param container
     * @param position
     * @param object
     */
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
