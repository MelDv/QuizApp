package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PicList extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_list);

        TextView scoreView = (TextView) findViewById(R.id.score);
        displayScore();

        ImageButton fin = (ImageButton) findViewById(R.id.right);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String right = getResources().getString(R.string.right_answer);
                createToast(right);
                score++;
                displayScore();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent flagIntent = new Intent(PicList.this, QList.class);
                        startActivity(flagIntent);
                    }
                }, 1200);
            }
        });

        ImageButton w1 = (ImageButton) findViewById(R.id.swe);
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "sweden";
                wrong(s);
            }
        });

        ImageButton w2 = (ImageButton) findViewById(R.id.gre);
        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "greece";
                wrong(s);
            }
        });

        ImageButton w3 = (ImageButton) findViewById(R.id.scot);
        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "scot";
                wrong(s);
            }
        });
    }

    public void createToast(String tstring) {
        Toast toast = Toast.makeText(this, tstring, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayScore() {
        TextView scoreView = (TextView) findViewById(R.id.score);
        String score_string = getResources().getString(R.string.score);
        scoreView.setText(score_string + String.valueOf(score) + "/8");
    }

    public void wrong(String country) {
        String toast_string = getResources().getString(R.string.wrong_flag);
        String flag_country = "";

        if (country.contentEquals("scot")) {
            flag_country = getResources().getString(R.string.scot);
        } else if (country.contentEquals("sweden")) {
            flag_country = getResources().getString(R.string.sweden);
        } else if (country.contentEquals("greece")) {
            flag_country = getResources().getString(R.string.greece);
        } else {
            toast_string = "Something went horribly wrong.";
        }

        String message = toast_string + flag_country;
        createToast(message);
    }
}
