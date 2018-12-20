package com.dsman.game_english;

import android.content.Context;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        score1 = 0;
        score2 = 0;
        ///////////////////////////////////
        setDataPrueba();
        ///////////////////////////////////

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

    ///////////////////////////////////

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

        answersForOne[0] = new String[]{"0", "am forgot"};
        answersForOne[1] = new String[]{"0", "has forgotten"};
        answersForOne[2] = new String[]{"1", "forgot"};

        listAnswers.put(1, answersForOne);

        answersForOne[0] = new String[]{"1", "applied"};
        answersForOne[1] = new String[]{"0", "am applied"};
        answersForOne[2] = new String[]{"0", "apply"};

        listAnswers.put(2, answersForOne);

        answersForOne[0] = new String[]{"1", "was"};
        answersForOne[1] = new String[]{"0", "are"};
        answersForOne[2] = new String[]{"0", "were"};

        listAnswers.put(3, answersForOne);

        answersForOne[0] = new String[]{"1", "while"};
        answersForOne[1] = new String[]{"0", "too"};
        answersForOne[2] = new String[]{"0", "finally"};

        listAnswers.put(4, answersForOne);

        answersForOne[0] = new String[]{"0", "here"};
        answersForOne[1] = new String[]{"1", "simultaneously"};
        answersForOne[2] = new String[]{"0", "beyond"};

        listAnswers.put(5, answersForOne);

        answersForOne[0] = new String[]{"0", "however"};
        answersForOne[1] = new String[]{"0", "at the same time"};
        answersForOne[2] = new String[]{"1", "because"};

        listAnswers.put(6, answersForOne);

        answersForOne[0] = new String[]{"0", "for geography places"};
        answersForOne[1] = new String[]{"1", "to refer to a whole group of people."};
        answersForOne[2] = new String[]{"0", "for proper names"};

        listAnswers.put(7, answersForOne);

        answersForOne[0] = new String[]{"1", "determine a thing or a person already known by speakers"};
        answersForOne[1] = new String[]{"0", "determine a thing already known by speakers"};
        answersForOne[2] = new String[]{"0", "determine a person already known by speakers"};

        listAnswers.put(8, answersForOne);

        answersForOne[0] = new String[]{"1", "yes"};
        answersForOne[1] = new String[]{"0", "no"};
        answersForOne[2] = new String[]{"0", "I don´t know"};

        listAnswers.put(9, answersForOne);

        answersForOne[0] = new String[]{"0", "yes"};
        answersForOne[1] = new String[]{"1", "no"};
        answersForOne[2] = new String[]{"0", "may be"};

        listAnswers.put(10, answersForOne);

        answersForOne[0] = new String[]{"1", "subject + verb infinitive"};
        answersForOne[1] = new String[]{"0", "subject + verb ing"};
        answersForOne[2] = new String[]{"0", "subject + to be + verb ing"};

        listAnswers.put(11, answersForOne);

        answersForOne[0] = new String[]{"0", "subject +to have + infinitive"};
        answersForOne[1] = new String[]{"0", "verb to be + infinitive"};
        answersForOne[2] = new String[]{"1", "subject + verb"};

        listAnswers.put(12, answersForOne);

        answersForOne[0] = new String[]{"0", "english"};
        answersForOne[1] = new String[]{"0", "american"};
        answersForOne[2] = new String[]{"1", "both"};

        listAnswers.put(13, answersForOne);

        answersForOne[0] = new String[]{"0", "english"};
        answersForOne[1] = new String[]{"1", "american"};
        answersForOne[2] = new String[]{"0", "both"};

        listAnswers.put(14, answersForOne);

        answersForOne[0] = new String[]{"1", "english"};
        answersForOne[1] = new String[]{"0", "american"};
        answersForOne[2] = new String[]{"0", "both"};

        listAnswers.put(15, answersForOne);

    }
    ///////////////////////////////////

    // Get data in ArrayLists in random position
    private void getRandomQuestion(){

        int numRandom = (int) (Math.random() * (listAnswers.size()- 1));
        int numIndex = 0;

        // get random answers
        // Get random Index with listQuestions because have less information for read
        for (Map.Entry allAsw: listQuestions.entrySet()){
            if (numRandom == (int) allAsw.getKey()){

                // Get question for the random Index
                for (String quest : listQuestions.values()){
                    if (numRandom == numIndex) {
                        Log.d("debuggggg" , numIndex + " " + quest);
                        question.setText(quest);
                    }
                        numIndex++;
                }

                numIndex = 0;
                // Get values for the random Index
                for (String[][] asw: listAnswers.values()){
                    if (numRandom == numIndex){
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


        for (String[][] asw: listAnswers.values()){
            if (Integer.parseInt(asw[nBtnQuest][0]) == 1){
                showResult("Correct");
                counterP1.setText(Integer.toString(score1=+1));
                getRandomQuestion();

            } else {
                showResult("Wrong");
                counterP2.setText(Integer.toString(score2=+1));
                getRandomQuestion();
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
