package com.example.caz.androidanimatedimages;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean animating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.animated_image_view);

        imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_couple_star));
        animating = false;
        final Drawable drawable = (imageView).getDrawable();

        if(drawable instanceof Animatable) {
            ((Animatable)drawable).start();
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!animating) {
                    imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_star_couple));
                    animating = true;
                } else {
                    imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_couple_star));
                    animating = false;
                }

                final Drawable drawable = imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable)drawable).start();
                }
            }
        });
    }
}