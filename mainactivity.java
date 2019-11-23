package com.example.capsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qNum = 0;
        capsApp = new CapsApp();
        score = 0;
        ask();
    }
    private CapsApp capsApp;
    private String question;
    private String answer;
    private int score;
    private int qNum;

    private void ask() {
        String qa = capsApp.qa();
        String[] part = qa.split("\n");
        question = part[0];
        answer = part[1];
        ((TextView)findViewById(R.id.question)).setText(question);
    }

    public void onDone(View V) {
        EditText getName = ((EditText)findViewById(R.id.answer));
        String input = getName.getText().toString();
        if (input.toUpperCase().equals(answer.toUpperCase())){
            score ++;
            ((TextView)findViewById(R.id.score)).setText("SCORE " + Integer.toString(score));
        }
        ((TextView)findViewById(R.id.log)).append("\n" + "Q# " + Integer.toString(qNum) +" "+ question);
        ((TextView)findViewById(R.id.log)).append("\n"+"Your answer: " + input);
        ((TextView)findViewById(R.id.log)).append("\n" + "Correct answer: " + answer);
        qNum ++;
        ((TextView)findViewById(R.id.qNum)).setText("Q# " + Integer.toString(qNum));
        if(qNum == 11){
            ((TextView)findViewById(R.id.qNum)).setText("Game Over!");
            ((TextView)findViewById(R.id.done)).setEnabled(false);
        }
        else{
            ask();
        }
}
}
