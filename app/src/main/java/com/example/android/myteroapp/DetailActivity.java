package com.example.android.myteroapp;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView mIcon;
    TextView mEmailTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mIcon = findViewById(R.id.tvIcon);
        mEmailTitle = findViewById(R.id.tvEmailTitle);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mIcon.setText(mBundle.getString("icon"));
            ((GradientDrawable) mIcon.getBackground()).setColor(mBundle.getInt("colorIcon"));
            mEmailTitle.setText(mBundle.getString("title"));
        }

    }
}
