package com.dsman.game_english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Questions extends AppCompatActivity {
    private List<String> preguntas = new List<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }
}
