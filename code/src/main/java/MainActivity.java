package com.project.user.rightsize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewBuest;
    private TextView textViewHips;
    private TextView textViewWaist;
    private TextView textViewNeck;
    private boolean isMan = true;

    final private int MAX_WOMAN_BUEST = 119;
    final private int MIN_WOMAN_BUEST = 84;
    final private int MAX_WOMAN_WAIST = 93;
    final private int MIN_WOMAN_WAIST = 56;
    final private int MAX_WOMAN_HIPS = 123;
    final private int MIN_WOMAN_HIPS = 88;

    final private int MAX_MAN_BUEST = 123;
    final private int MIN_MAN_BUEST = 92;
    final private int MAX_MAN_WAIST = 107;
    final private int MIN_MAN_WAIST = 76;
    final private int MAX_MAN_HIPS = 115;
    final private int MIN_MAN_HIPS = 84;
    final private int MAX_MAN_NECK = 51;
    final private int MIN_MAN_NECK = 38;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDo = (Button) findViewById(R.id.buttonDo);

        Button buttonIncreaseBuest = (Button) findViewById(R.id.buttonIncreaseBuest);
        Button buttonREduceBuest = (Button) findViewById(R.id.buttonReduceBuest);
        Button buttonIncreaseHips = (Button) findViewById(R.id.buttonIncreaseHips);
        Button buttonReduceHips = (Button) findViewById(R.id.buttonReduceHips);
        Button buttonIncreaseWaist = (Button) findViewById(R.id.buttonIncreaseWaist);
        Button buttonReduceWaist = (Button) findViewById(R.id.buttonReduceWaist);
        Button buttonIncreaseNeck = (Button) findViewById(R.id.buttonIncreaseNeck);
        Button buttonReduceNeck = (Button) findViewById(R.id.buttonReduceNeck);

        Button buttonWoman = (Button) findViewById(R.id.buttonWoman);
        Button buttonMan = (Button) findViewById(R.id.buttonMan);


        textViewBuest = (TextView) findViewById(R.id.textViewBuest);
        textViewHips = (TextView) findViewById(R.id.textViewHips);
        textViewWaist = (TextView) findViewById(R.id.textViewWaist);
        textViewNeck = (TextView) findViewById(R.id.textViewNeck);

        buttonIncreaseBuest.setOnClickListener(buestClickListener);
        buttonREduceBuest.setOnClickListener(buestClickListener);

        buttonIncreaseWaist.setOnClickListener(waistClickListener);
        buttonReduceWaist.setOnClickListener(waistClickListener);

        buttonIncreaseHips.setOnClickListener(hipsClickListener);
        buttonReduceHips.setOnClickListener(hipsClickListener);

        buttonIncreaseNeck.setOnClickListener(neckClickListener);
        buttonReduceNeck.setOnClickListener(neckClickListener);

        buttonMan.setOnClickListener(genderClickListener);
        buttonWoman.setOnClickListener(genderClickListener);
        buttonDo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Calculator calc = new Calculator(isMan, this, Integer.valueOf(textViewBuest.getText().toString()),
                Integer.valueOf(textViewWaist.getText().toString()), Integer.valueOf(textViewHips.getText().toString()));
        Intent i;
        i = new Intent(this, ResultActivity.class);
        i.putExtra("RusSize", String.valueOf(calc.result.rusSize));
        i.putExtra("USASize", String.valueOf(calc.result.USASize));
        i.putExtra("WorldSize", calc.result.worldSize);
        i.putExtra("Type", calc.result.typeOfBody);
        startActivity(i);
    }


    private View.OnClickListener buestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonIncreaseBuest: {
                    int temp = Integer.valueOf(textViewBuest.getText().toString());
                    if ((temp < MAX_WOMAN_BUEST && isMan == false) || (temp < MAX_MAN_BUEST && isMan == true)) {
                        temp++;
                        textViewBuest.setText(String.valueOf(temp));
                    }
                    break;
                }
                case R.id.buttonReduceBuest: {
                    int temp = Integer.valueOf(textViewBuest.getText().toString());
                    if ((temp > MIN_WOMAN_BUEST && isMan == false) || (temp > MIN_MAN_BUEST && isMan == true)) {
                        temp--;
                        textViewBuest.setText(String.valueOf(temp));
                    }
                    break;
                }
            }
        }
    };

    private View.OnClickListener waistClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonIncreaseWaist: {
                    int temp = Integer.valueOf(textViewWaist.getText().toString());
                    if ((temp < MAX_WOMAN_WAIST && isMan == false) || (temp < MAX_MAN_WAIST && isMan == true)) {
                        temp++;
                        textViewWaist.setText(String.valueOf(temp));
                    }
                    break;
                }
                case R.id.buttonReduceWaist: {
                    int temp = Integer.valueOf(textViewWaist.getText().toString());
                    if ((temp > MIN_WOMAN_WAIST && isMan == false) || (temp > MIN_MAN_WAIST && isMan == true)) {
                        temp--;
                        textViewWaist.setText(String.valueOf(temp));
                    }
                    break;
                }
            }
        }
    };

    private View.OnClickListener hipsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonIncreaseHips: {
                    int temp = Integer.valueOf(textViewHips.getText().toString());
                    if ((temp < MAX_WOMAN_HIPS && isMan == false) || (temp < MAX_MAN_HIPS && isMan == true)) {
                        temp++;
                        textViewHips.setText(String.valueOf(temp));
                    }
                    break;
                }
                case R.id.buttonReduceHips: {
                    int temp = Integer.valueOf(textViewHips.getText().toString());
                    if ((temp > MIN_WOMAN_HIPS && isMan == false) || (temp > MIN_MAN_HIPS && isMan == true)) {
                        temp--;
                        textViewHips.setText(String.valueOf(temp));
                    }
                    break;
                }
            }
        }
    };


    private View.OnClickListener neckClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonIncreaseNeck: {
                    int temp = Integer.valueOf(textViewNeck.getText().toString());
                    if (temp < MAX_MAN_NECK && isMan == true) {
                        temp++;
                        textViewNeck.setText(String.valueOf(temp));
                    }
                    break;
                }
                case R.id.buttonReduceNeck: {
                    int temp = Integer.valueOf(textViewNeck.getText().toString());
                    if (temp > MIN_MAN_NECK && isMan == true) {
                        temp--;
                        textViewNeck.setText(String.valueOf(temp));
                    }
                    break;
                }
            }
        }
    };


    private View.OnClickListener genderClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button buttonIncreaseNeck = (Button) findViewById(R.id.buttonIncreaseNeck);
            Button buttonReduceNeck = (Button) findViewById(R.id.buttonReduceNeck);
            TextView neck = (TextView) findViewById(R.id.labelNeck);
            Button buttonWoman = (Button) findViewById(R.id.buttonWoman);
            Button buttonMan = (Button) findViewById(R.id.buttonMan);

            switch (v.getId()) {
                case R.id.buttonMan: {
                    isMan = true;
                    buttonIncreaseNeck.setVisibility(View.VISIBLE);
                    buttonReduceNeck.setVisibility(View.VISIBLE);
                    textViewNeck.setVisibility(View.VISIBLE);
                    neck.setVisibility(View.VISIBLE);

                    buttonMan.setEnabled(false);
                    buttonWoman.setEnabled(true);

                    textViewBuest.setText(String.valueOf((MAX_MAN_BUEST + MIN_MAN_BUEST) / 2));
                    textViewHips.setText(String.valueOf((MAX_MAN_HIPS + MIN_MAN_HIPS) / 2));
                    textViewWaist.setText(String.valueOf((MAX_MAN_WAIST + MIN_MAN_WAIST) / 2));
                    textViewNeck.setText(String.valueOf((MAX_MAN_NECK + MIN_MAN_NECK) / 2));
                    break;
                }
                case R.id.buttonWoman: {
                    isMan = false;

                    buttonIncreaseNeck.setVisibility(View.INVISIBLE);
                    buttonReduceNeck.setVisibility(View.INVISIBLE);
                    textViewNeck.setVisibility(View.INVISIBLE);
                    neck.setVisibility(View.INVISIBLE);

                    buttonMan.setEnabled(true);
                    buttonWoman.setEnabled(false);

                    textViewBuest.setText(String.valueOf((MAX_WOMAN_BUEST + MIN_WOMAN_BUEST) / 2));
                    textViewHips.setText(String.valueOf((MAX_WOMAN_HIPS + MIN_WOMAN_HIPS) / 2));
                    textViewWaist.setText(String.valueOf((MAX_WOMAN_WAIST + MIN_WOMAN_WAIST) / 2));
                    textViewNeck.setText(String.valueOf(0));
                    break;
                }
            }
        }
    };
}


