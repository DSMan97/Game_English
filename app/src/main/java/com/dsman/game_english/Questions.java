package com.dsman.game_english;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

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
        question = findViewById(R.id.textView);

        // Listener Buttons
        setListeners();
        getRandomQuestion();
    }

    private void setListeners(){
        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(0);
            }
        });
        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(1);
            }
        });
        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAnswer(2);
            }
        });
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
        int numIndex = 0;


        // get random answers
        // Get random Index with listQuestions because have less information for read
        for (Map.Entry allAsw: listQuestions.entrySet()){
            allAsw.getKey();
            if (numRandom == (int) allAsw.getKey()){
                numIndex = (int) allAsw.getKey();
            }
        }

        // Get question for the random Index
        for (String quest : listQuestions.values()){
            if (numRandom == numIndex) {
                question.setText(quest);
            }
        }

        // Get values for the random Index
        for (String[][] asw: listAnswers.values()){
            if (numRandom == numIndex){
                btnR1.setText(asw[0][1]);
                btnR2.setText(asw[1][1]);
                btnR3.setText(asw[2][1]);
            }
        }
    }

    private void onClickAnswer (int nBtnQuest){

        for (String[][] asw: listAnswers.values()){
            if (Integer.parseInt(asw[nBtnQuest][0]) == 1){
                showResult("ACERTASTES");
            } else {
                showResult("FALLASTES");
            }
        }
    }

    private void showResult(String result){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, result, duration);
        toast.show();
    }

    private void doAnimation(){

    }
}
