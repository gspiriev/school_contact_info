package com.spiriev.android.schoolcontactinfo;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dobriHristovText = (TextView) findViewById(R.id.dobri_hristov_text_id);
        Button buttonText = (Button) findViewById(R.id.gallery_button_id);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "AmaticSC-Regular.ttf");

        dobriHristovText.setTypeface(typeface);
        buttonText.setTypeface(typeface);

    }

    /**
     * Callback method which opens the image preview dialog
     *
     * @param view The ImageButton on the main activity
     */
    public void openImageDialog(View view) {
        DialogFragment imageDialog = new SchoolPhotosDialog();
        imageDialog.show(getFragmentManager(), "images");
    }

    /**
     * Callback method which starts the gallery activity
     *
     * @param view ImageButton in the image preview dialog
     */
    public void openGallery(View view) {
        //this part is a bit ugly but it works
        int position = 0;
        switch (view.getId()) {
            case R.id.image_1:
                position = 0;
                break;
            case R.id.image_2:
                position = 1;
                break;
            case R.id.image_3:
                position = 2;
                break;
            case R.id.image_4:
                position = 3;
                break;
            case R.id.image_5:
                position = 4;
                break;
        }

        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("POSITION_KEY", position);
        startActivity(intent);
    }
}
