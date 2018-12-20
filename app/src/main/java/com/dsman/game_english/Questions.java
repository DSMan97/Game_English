package com.dsman.game_english;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.KeyStore;
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
        question = findViewById(R.id.textView);

        // Listener Buttons
        setListeners();
        getRandomQuestion();
    }

    ///////////////////////////////////

    // guarda las respuestas en un hashmap <n preg, preg>
    // guarda las respuestas en un hashmap <n preg, arr de preg + boolean verdadero o falso>
    private void setDataPrueba(){

        listQuestions = new HashMap<>();
        listQuestions.put(1,"It ---- raining for a while, but now it’s raining again");
        listQuestions.put(2,"I did German at school, but I --- most of it now");
        listQuestions.put(3,"I --- for a job as a tourist guide, but i wasn’t succesful");
        listQuestions.put(4,"Look! There’s an ambulance over there. There --- an accident");
        listQuestions.put(5,"Addition");
        listQuestions.put(6,"Place");
        listQuestions.put(7,"Contrast");
        listQuestions.put(8,"When you use the article “the”");
        listQuestions.put(9,"What is the main use of the particular article");
        listQuestions.put(10,"The determined article is used with unique reference name?");
        listQuestions.put(11,"This sentence is correct ? : Despite of the bad weather, there was a large crowd at the match");
        listQuestions.put(12,"This sentence is correct ? : After althoug we use…");
        listQuestions.put(13,"This sentence is correct ? : After even though is followed by …");
        listQuestions.put(14,"Indicates what type of expression is, if American, English or the same for both: Size");
        listQuestions.put(15,"Indicates what type of expression is, if American, English or the same for both: Defense");
        listQuestions.put(16,"Indicates what type of expression is, if American, English or the same for both: Centre");



        listAnswers = new HashMap<>();
        String[][] answersForOne = new String[3][2];

        answersForOne[0] = new String[]{"0", "is stop"};
        answersForOne[1] = new String[]{"1", "has stopped"};
        answersForOne[2] = new String[]{"0", "is stopping"};

        listAnswers.put(1, answersForOne);

        answersForOne[0] = new String[]{"0", "am forgot"};
        answersForOne[1] = new String[]{"0", "has forgotten"};
        answersForOne[2] = new String[]{"1", "forgot"};

        listAnswers.put(2, answersForOne);

        answersForOne[0] = new String[]{"1", "applied"};
        answersForOne[1] = new String[]{"0", "am applied"};
        answersForOne[2] = new String[]{"0", "apply"};

        listAnswers.put(3, answersForOne);

        answersForOne[0] = new String[]{"1", "was"};
        answersForOne[1] = new String[]{"0", "are"};
        answersForOne[2] = new String[]{"0", "were"};

        listAnswers.put(4, answersForOne);

        answersForOne[0] = new String[]{"1", "while"};
        answersForOne[1] = new String[]{"0", "too"};
        answersForOne[2] = new String[]{"0", "finally"};

        listAnswers.put(5, answersForOne);

        answersForOne[0] = new String[]{"0", "here"};
        answersForOne[1] = new String[]{"1", "simultaneously"};
        answersForOne[2] = new String[]{"0", "beyond"};

        listAnswers.put(6, answersForOne);

        answersForOne[0] = new String[]{"0", "however"};
        answersForOne[1] = new String[]{"0", "at the same time"};
        answersForOne[2] = new String[]{"1", "because"};

        listAnswers.put(7, answersForOne);

        answersForOne[0] = new String[]{"0", "for geography places"};
        answersForOne[1] = new String[]{"1", "to refer to a whole group of people."};
        answersForOne[2] = new String[]{"0", "for proper names"};

        listAnswers.put(8, answersForOne);

        answersForOne[0] = new String[]{"1", "determine a thing or a person already known by speakers"};
        answersForOne[1] = new String[]{"0", "determine a thing already known by speakers"};
        answersForOne[2] = new String[]{"0", "determine a person already known by speakers"};

        listAnswers.put(9, answersForOne);

        answersForOne[0] = new String[]{"1", "yes"};
        answersForOne[1] = new String[]{"0", "no"};
        answersForOne[2] = new String[]{"0", "I don´t know"};

        listAnswers.put(10, answersForOne);

        answersForOne[0] = new String[]{"0", "yes"};
        answersForOne[1] = new String[]{"1", "no"};
        answersForOne[2] = new String[]{"0", "may be"};

        listAnswers.put(11, answersForOne);

        answersForOne[0] = new String[]{"1", "subject + verb infinitive"};
        answersForOne[1] = new String[]{"0", "subject + verb ing"};
        answersForOne[2] = new String[]{"0", "subject + to be + verb ing"};

        listAnswers.put(12, answersForOne);

        answersForOne[0] = new String[]{"0", "subject +to have + infinitive"};
        answersForOne[1] = new String[]{"0", "verb to be + infinitive"};
        answersForOne[2] = new String[]{"1", "subject + verb"};

        listAnswers.put(13, answersForOne);

        answersForOne[0] = new String[]{"0", "english"};
        answersForOne[1] = new String[]{"0", "american"};
        answersForOne[2] = new String[]{"1", "both"};

        listAnswers.put(14, answersForOne);

        answersForOne[0] = new String[]{"0", "english"};
        answersForOne[1] = new String[]{"1", "american"};
        answersForOne[2] = new String[]{"0", "both"};

        listAnswers.put(15, answersForOne);

        answersForOne[0] = new String[]{"1", "english"};
        answersForOne[1] = new String[]{"0", "american"};
        answersForOne[2] = new String[]{"0", "both"};

        listAnswers.put(16, answersForOne);

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
