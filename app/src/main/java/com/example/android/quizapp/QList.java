package com.example.android.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.layout.qlist;

public class QList extends AppCompatActivity {
    private int score = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(qlist);

        displayScore();
    }

    public void displayScore() {
        TextView scoreView = (TextView) findViewById(R.id.score);
        String score_string = getResources().getString(R.string.score);
        scoreView.setText(score_string + String.valueOf(score) + "/8");
    }

    public void countPoints(View view) {
        RadioButton r1 = (RadioButton) findViewById(R.id.swan);
        if (r1.isChecked()) {
            addPoint();
        }

        RadioButton r2 = (RadioButton) findViewById(R.id.stahl);
        if (r2.isChecked()) {
            addPoint();
        }

        RadioButton r3 = (RadioButton) findViewById(R.id.bear);
        if (r3.isChecked()) {
            addPoint();
        }

        RadioButton r4 = (RadioButton) findViewById(R.id.sale);
        if (r4.isChecked()) {
            addPoint();
        }

        CheckBox rus = (CheckBox) findViewById(R.id.rus);
        CheckBox swe = (CheckBox) findViewById(R.id.swe);
        CheckBox jap = (CheckBox) findViewById(R.id.jap);
        CheckBox fra = (CheckBox) findViewById(R.id.fra);

        if (swe.isChecked() && rus.isChecked() && !jap.isChecked() && !fra.isChecked()) {
            addPoint();
            addPoint();
        } else if (swe.isChecked() && rus.isChecked() && jap.isChecked() && fra.isChecked()) {
            score = score;
        } else if (swe.isChecked() || rus.isChecked()) {
            addPoint();
        }

        EditText name = (EditText) findViewById(R.id.fin_name);
        String fin = name.getText().toString().toLowerCase().trim();
        if (fin.contains("suomi")) {
            addPoint();
        }

        displayScore();
        String points = getResources().getString(R.string.points);
        Toast toast = Toast.makeText(this, points + " " + score + "/8", Toast.LENGTH_LONG);
        toast.show();
        score = 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent answerIntent = new Intent(QList.this, CorrectAnswers.class);
                startActivity(answerIntent);
            }
        }, 1500);
    }


    private void addPoint() {
        if (score < 8) {
            score++;
        }
    }
}