package com.single.mvpandroid;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    String name, teacher, description, place, startTime, endTime;
    TextView time, nameD, descriptionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("description");
        teacher = getIntent().getStringExtra("teacher");
        place = getIntent().getStringExtra("place");
        endTime = getIntent().getStringExtra("endTime");
        startTime = getIntent().getStringExtra("startTime");

        time = (TextView) findViewById(R.id.time_detail);
        nameD = (TextView) findViewById(R.id.name_detail);
        descriptionD  = (TextView) findViewById(R.id.d_detail);

        time.setText(startTime + " - " + endTime);
        nameD.setText(name);
        descriptionD.setText(description);
    }
}
