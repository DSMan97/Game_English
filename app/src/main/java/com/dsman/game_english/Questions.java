package com.dsman.game_english;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.icu.lang.UProperty.MATH;

public class Questions extends AppCompatActivity {
    private HashMap<Integer, String> listQuestions;
    private HashMap<Integer, String[][]> listAnswers;

    private Button btnR1, btnR2, btnR3;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

    ///////////////////////////////////
        setDataPrueba();
     ///////////////////////////////////

        // getViewByID
        btnR1 = findViewById(R.id.btna1);
        btnR2 = findViewById(R.id.btna2);
        btnR3 = findViewById(R.id.btna3);

        // Listener Buttons
        setListeners();
        getRandomQuestion();
    }

    ///////////////////////////////////

    // guarda las respuestas en un hashmap <n preg, preg>
    // guarda las respuestas en un hashmap <n preg, arr de preg + boolean verdadero o falso>
    private void setDataPrueba(){

        listQuestions = new HashMap<>();
        listQuestions.put(1, "primera pregunta");

        listAnswers = new HashMap<>();
        String[][] answersForOne = new String[3][2];

        answersForOne[0] = new String[]{"1", "1º respuesta"};
        answersForOne[1] = new String[]{"0", "2º respuesta"};
        answersForOne[2] = new String[]{"0", "3º respuesta"};

        listAnswers.put(1, answersForOne);
    }
    ///////////////////////////////////

    // Get data in ArrayLists in random position
    private void getRandomQuestion(){

        int numRandom = (int) (Math.random() * (listAnswers.size()- 1));
        String asw1 = "";
        String asw2 = "";
        String asw3 = "";

        // get random answers

        // HashMap < Integer, ["falso/cierto", "pregunta"]>
        for (Map.Entry asw: listAnswers.entrySet() ){
            if (numRandom == Integer.parseInt(asw.getValue().toString())){
//                asw1 =
            }
        }
    }

    private void setDataInView(String asw1, String asw2, String asw3){
        btnR1.setText(asw1);
        btnR2.setText(asw2);
        btnR3.setText(asw3);
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
