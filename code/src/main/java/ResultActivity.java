package com.project.user.rightsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textViewRus = (TextView)findViewById(R.id.textViewRus);
        TextView textViewUSA = (TextView)findViewById(R.id.textViewUSA);
        TextView textViewWorld = (TextView)findViewById(R.id.textViewWorld);
        TextView textViewType = (TextView)findViewById(R.id.textViewType);

        Bundle arguments =  getIntent().getExtras();
        textViewRus.setText(arguments.get("RusSize").toString());
        textViewUSA.setText(arguments.get("USASize").toString());
        textViewWorld.setText(arguments.get("WorldSize").toString());
        textViewType.setText(arguments.get("Type").toString());
    }
}
