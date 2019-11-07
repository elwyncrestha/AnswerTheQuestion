package com.elvin.answerthequestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random = new Random();
    private int firstNumber;
    private int secondNumber;
    private int score;
    private Button btnFirstNumber;
    private Button btnSecondNumber;
    private TextView tvScore;
    private TextView tvWinOrLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindControls();
        configureListeners();
        generateRandom();
    }

    private void bindControls() {
        this.btnFirstNumber = findViewById(R.id.btnFirstNumber);
        this.btnSecondNumber = findViewById(R.id.btnSecondNumber);
        this.tvScore = findViewById(R.id.tvScore);
        this.tvWinOrLose = findViewById(R.id.tvWinOrLose);
        this.tvWinOrLose.setVisibility(View.INVISIBLE);
    }

    private void configureListeners() {
        this.btnFirstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore(true);
            }
        });
        this.btnSecondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore(false);
            }
        });
    }

    private void generateRandom() {
        this.firstNumber = random.nextInt(100);
        this.secondNumber = random.nextInt(100);

        this.btnFirstNumber.setText(String.valueOf(this.firstNumber));
        this.btnSecondNumber.setText(String.valueOf(this.secondNumber));
    }

    private void calculateScore(boolean isFirstButton) {
        if (isFirstButton) {
            this.score += this.firstNumber > this.secondNumber ? 1 : -1;
        } else {
            this.score += this.firstNumber < this.secondNumber ? 1 : -1;
        }
        this.tvScore.setText(String.valueOf(this.score));
        if (this.score >= 10) {
            this.tvWinOrLose.setText("YOU WIN!!!");
            this.tvWinOrLose.setVisibility(View.VISIBLE);
        } else if (this.score <= -10) {
            this.tvWinOrLose.setText("YOU LOSE!!!");
            this.tvWinOrLose.setVisibility(View.VISIBLE);
        } else {
            this.tvWinOrLose.setVisibility(View.INVISIBLE);
        }
        generateRandom();
    }
}
