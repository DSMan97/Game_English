package com.dsman.game_english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {
    private List<String> preguntas = new ArrayList<>();
    private List<String []> prespuestas = new ArrayList<>();

    private Button btnR1, btnR2, btnR3;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // getViewByID
        btnR1 = findViewById(R.id.btna1);
        btnR2 = findViewById(R.id.btna2);
        btnR3 = findViewById(R.id.btna3);

        // Listener Buttons
        setListeners();

    }

    private void setListeners(){
        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(1);
            }
        });
        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(2);
            }
        });
        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(3);
            }
        });

    }

    private void onClickAnswer (int nPreg){

    }

    private void showResult(){

    }

    private void doAnimation(){

    }
}
