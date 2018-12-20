package com.dsman.game_english;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private  TextView counterP1,counterP2;
    private int score1, score2;
    private int numberQuestion;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        score1 = 0;
        score2 = 0;
        ///////////////////////////////////
        setDataPrueba();
        ///////////////////////////////////

        mp = MediaPlayer.create(this, R.raw.music);
        // getViewByID
        btnR1 = findViewById(R.id.btna1);
        btnR2 = findViewById(R.id.btna2);
        btnR3 = findViewById(R.id.btna3);
        question = findViewById(R.id.textView);
        counterP1 = findViewById(R.id.score1);
        counterP2 = findViewById(R.id.score2);

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

    // guarda las respuestas en un hashmap <n preg, preg>
    // guarda las respuestas en un hashmap <n preg, arr de preg + boolean verdadero o falso>
    private void setDataPrueba(){

        listQuestions = new HashMap<>();
        listQuestions.put(0,"It ---- raining for a while, but now it’s raining again");
        listQuestions.put(1,"I did German at school, but I --- most of it now");
        listQuestions.put(2,"I --- for a job as a tourist guide, but i wasn’t succesful");
        listQuestions.put(3,"Look! There’s an ambulance over there. There --- an accident");
        listQuestions.put(4,"Addition");
        listQuestions.put(5,"Place");
        listQuestions.put(6,"Contrast");
        listQuestions.put(7,"When you use the article “the”");
        listQuestions.put(8,"What is the main use of the particular article");
        listQuestions.put(9,"The determined article is used with unique reference name?");
        listQuestions.put(10,"This sentence is correct ? : Despite of the bad weather, there was a large crowd at the match");
        listQuestions.put(11,"This sentence is correct ? : After althoug we use…");
        listQuestions.put(12,"This sentence is correct ? : After even though is followed by …");
        listQuestions.put(13,"Indicates what type of expression is, if American, English or the same for both: Size");
        listQuestions.put(14,"Indicates what type of expression is, if American, English or the same for both: Defense");
        listQuestions.put(15,"Indicates what type of expression is, if American, English or the same for both: Centre");



        listAnswers = new HashMap<>();


        String[][] answersForOne = new String[3][2];

        answersForOne[0] = new String[]{"0", "is stop"};
        answersForOne[1] = new String[]{"1", "has stopped"};
        answersForOne[2] = new String[]{"0", "is stopping"};

        listAnswers.put(0, answersForOne);

        String[][] answersForOne1 = new String[3][2];
        answersForOne1[0] = new String[]{"0", "am forgot"};
        answersForOne1[1] = new String[]{"0", "has forgotten"};
        answersForOne1[2] = new String[]{"1", "forgot"};

        listAnswers.put(1, answersForOne1);

        String[][] answersForOne2 = new String[3][2];
        answersForOne2[0] = new String[]{"1", "applied"};
        answersForOne2[1] = new String[]{"0", "am applied"};
        answersForOne2[2] = new String[]{"0", "apply"};

        listAnswers.put(2, answersForOne2);

        String[][] answersForOne3 = new String[3][2];
        answersForOne3[0] = new String[]{"1", "was"};
        answersForOne3[1] = new String[]{"0", "are"};
        answersForOne3[2] = new String[]{"0", "were"};

        listAnswers.put(3, answersForOne3);

        String[][] answersForOne4 = new String[3][2];
        answersForOne4[0] = new String[]{"1", "while"};
        answersForOne4[1] = new String[]{"0", "too"};
        answersForOne4[2] = new String[]{"0", "finally"};

        listAnswers.put(4, answersForOne4);

        String[][] answersForOne5 = new String[3][2];
        answersForOne5[0] = new String[]{"0", "here"};
        answersForOne5[1] = new String[]{"1", "simultaneously"};
        answersForOne5[2] = new String[]{"0", "beyond"};

        listAnswers.put(5, answersForOne5);

        String[][] answersForOne6 = new String[3][2];
        answersForOne6[0] = new String[]{"0", "however"};
        answersForOne6[1] = new String[]{"0", "at the same time"};
        answersForOne6[2] = new String[]{"1", "because"};

        listAnswers.put(6, answersForOne6);

        String[][] answersForOne7 = new String[3][2];
        answersForOne7[0] = new String[]{"0", "for geography places"};
        answersForOne7[1] = new String[]{"1", "to refer to a whole group of people."};
        answersForOne7[2] = new String[]{"0", "for proper names"};

        listAnswers.put(7, answersForOne7);

        String[][] answersForOne8 = new String[3][2];
        answersForOne8[0] = new String[]{"1", "thing or a person already known by speakers"};
        answersForOne8[1] = new String[]{"0", "thing already known by speakers"};
        answersForOne8[2] = new String[]{"0", "person already known by speakers"};

        listAnswers.put(8, answersForOne8);

        String[][] answersForOne9 = new String[3][2];
        answersForOne9[0] = new String[]{"1", "yes"};
        answersForOne9[1] = new String[]{"0", "no"};
        answersForOne9[2] = new String[]{"0", "I don´t know"};

        listAnswers.put(9, answersForOne9);

        String[][] answersForOne10 = new String[3][2];
        answersForOne10[0] = new String[]{"0", "yes"};
        answersForOne10[1] = new String[]{"1", "no"};
        answersForOne10[2] = new String[]{"0", "may be"};

        listAnswers.put(10, answersForOne10);

        String[][] answersForOne11= new String[3][2];
        answersForOne11[0] = new String[]{"1", "subject + verb infinitive"};
        answersForOne11[1] = new String[]{"0", "subject + verb ing"};
        answersForOne11[2] = new String[]{"0", "subject + to be + verb ing"};

        listAnswers.put(11, answersForOne11);

        String[][] answersForOne12 = new String[3][2];
        answersForOne12[0] = new String[]{"0", "subject +to have + infinitive"};
        answersForOne12[1] = new String[]{"0", "verb to be + infinitive"};
        answersForOne12[2] = new String[]{"1", "subject + verb"};

        listAnswers.put(12, answersForOne12);

        String[][] answersForOne13 = new String[3][2];
        answersForOne13[0] = new String[]{"0", "english"};
        answersForOne13[1] = new String[]{"0", "american"};
        answersForOne13[2] = new String[]{"1", "both"};

        listAnswers.put(13, answersForOne13);

        String[][] answersForOne14 = new String[3][2];
        answersForOne14[0] = new String[]{"0", "english"};
        answersForOne14[1] = new String[]{"1", "american"};
        answersForOne14[2] = new String[]{"0", "both"};

        listAnswers.put(14, answersForOne14);

        String[][] answersForOne15 = new String[3][2];
        answersForOne15[0] = new String[]{"1", "english"};
        answersForOne15[1] = new String[]{"0", "american"};
        answersForOne15[2] = new String[]{"0", "both"};

        listAnswers.put(15, answersForOne15);

    }


    // Get data in ArrayLists in random position
    private void getRandomQuestion(){

        numberQuestion = (int) (Math.random() * (listAnswers.size()- 1));
        int numIndex = 0;

        // get random answers
        // Get random Index with listQuestions because have less information for read
        for (Map.Entry allAsw: listQuestions.entrySet()){
            if (numberQuestion == (int) allAsw.getKey()){

                // Get question for the random Index
                for (String quest : listQuestions.values()){
                    if (numberQuestion == numIndex) {
                        Log.d("debuggggg" , numIndex + " " + quest);
                        question.setText(quest);
                    }
                    numIndex++;
                }

                numIndex = 0;
                // Get values for the random Index
                for (String[][] asw: listAnswers.values()){
                    if (numberQuestion == numIndex){
                        Log.d("debuggggg" , numIndex + " " + asw[0][1] + " " + asw[1][1] + " " + asw[2][1]);
                        btnR1.setText(asw[0][1]);
                        btnR2.setText(asw[1][1]);
                        btnR3.setText(asw[2][1]);
                    }
                    numIndex++;
                }
            }
        }
    }

    private void onClickAnswer (int nBtnQuest){

        for (Map.Entry allAsw: listQuestions.entrySet()){
            if (numberQuestion == (int) allAsw.getKey()){
                Log.d("debugggggerrrrr", listAnswers.get(allAsw.getKey()).toString());
                String [][] pregunta = listAnswers.get(allAsw.getKey());

                //if (Integer.parseInt(pregunta[nBtnQuest][0]) == 1 || Integer.parseInt(pregunta[nBtnQuest][1]) == 1 || Integer.parseInt(pregunta[nBtnQuest][2]) == 1){
                if (pregunta[nBtnQuest][0].equals("1")){
                getCorrect();
                    showResult("Correct");
                    mp.start();
                    String res1 = Integer.toString(score1 += 1);
                    counterP1.setText(res1);
                    getRandomQuestion();

                } else {
                    getWrong();
                    showResult("Wrong");
                    mp.start();
                    String res2 = Integer.toString(score2 += 1);
                    counterP2.setText(res2);
                    getRandomQuestion();
                }
            }
        }

        haveFive();
    }

    private void haveFive(){
        if (score1 >= 5){
            getWin();
            mp.start();
            showResult("WIN !!!!!!");
            goToMain();
        } else if (score2 >= 5){
            getLose();
            mp.start();
            showResult("LOSE !!!!!!");
            goToMain();
        }
    }

    private void goToMain(){
        Intent navigate = new Intent(Questions.this, MainActivity.class);
        startActivity(navigate);
    }

    private void showResult(String result){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, result, duration);
        toast.show();
    }

    private  void getWin(){
        mp = MediaPlayer.create(this, R.raw.win);
    }
    private  void getLose(){
        mp = MediaPlayer.create(this, R.raw.lose);
    }
    private void getCorrect(){
        mp = MediaPlayer.create(this, R.raw.correct);
    }
    private void getWrong(){
        mp = MediaPlayer.create(this, R.raw.wrong);
    }
}
