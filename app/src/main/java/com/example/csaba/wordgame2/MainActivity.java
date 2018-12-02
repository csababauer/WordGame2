package com.example.csaba.wordgame2;

import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private String[] letters = {"a", "e", "s", "d", "n"};

    private String[] words ={"deans", "saned", "sedan", "ands", "anes", "dean", "dens", "ends", "sade", "sand", "sane", "send", "sned",
            "ads", "and", "ane", "den", "end", "ens", "nae", "sad", "sae", "sea", "sen"};

    private Button buttonLetter1, buttonLetter2, buttonLetter3, buttonLetter4, buttonLetter5;
    private Random rand;
    private int index1, index2, index3, index4, index5;
    private int count;
    private String typing;
    private int newScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLetter1 = (Button) findViewById(R.id.word1);
        buttonLetter2 = (Button) findViewById(R.id.word2);
        buttonLetter3 = (Button) findViewById(R.id.word3);
        buttonLetter4 = (Button) findViewById(R.id.word4);
        buttonLetter5 = (Button) findViewById(R.id.word5);

        //make the initial random letters
        makeRandomLetter();

        // setup an onclick listener on reset
        Button resetLetters = (Button) findViewById(R.id.reset);
        resetLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRandomLetter();
                makeLettersClickable();
                clearField();
                clearScore();
                newScore = 0;
            }
        });

        // setup an onclick listener on clear
        final Button clearField = (Button) findViewById(R.id.clear);
        clearField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearField();
                makeLettersClickable();
            }
        });
        /**setup the submit button listener for logocal comparison*/
        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compare();

            }
        });



        //setup onclick listener on each letter
        buttonLetter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeLetter(0);
                //make the letter unclickable
                buttonLetter1.setEnabled(false);
            }
        });
        buttonLetter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeLetter(1);
                //make the letter unclickable
                buttonLetter2.setEnabled(false);
            }
        });
        buttonLetter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeLetter(2);
                //make the letter unclickable
                buttonLetter3.setEnabled(false);
            }
        });
        buttonLetter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeLetter(3);
                //make the letter unclickable
                buttonLetter4.setEnabled(false);
            }
        });
        buttonLetter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeLetter(4);
                //make the letter unclickable
                buttonLetter5.setEnabled(false);
            }
        });

    }

    private void makeRandomLetter() {

//        rand = new Random();
//
//        //create 5 random numbers
//        index1 = rand.nextInt(letters.length - 1);
//        index2 = rand.nextInt(letters.length - 1);
//        index3 = rand.nextInt(letters.length - 1);
//        index4 = rand.nextInt(letters.length - 1);
//        index5 = rand.nextInt(letters.length - 1);

        //write 5 randomly created numbers on the buttons
        buttonLetter1.setText(letters[0]);
        buttonLetter2.setText(letters[1]);
        buttonLetter3.setText(letters[2]);
        buttonLetter4.setText(letters[3]);
        buttonLetter5.setText(letters[4]);
    }

    //write 1 letter
    private void writeLetter(int count){
        TextView typed = (TextView) findViewById(R.id.typed);
        typed.setText(typed.getText()+letters[count]);

    }

    private void makeLettersClickable(){
        buttonLetter1.setEnabled(true);
        buttonLetter2.setEnabled(true);
        buttonLetter3.setEnabled(true);
        buttonLetter4.setEnabled(true);
        buttonLetter5.setEnabled(true);
    }

    //clear field
    private void clearField(){
        TextView typed = (TextView) findViewById(R.id.typed);
        typed.setText("");

    }

    //compare result with array elements
    private void compare (){

        TextView typed = (TextView) findViewById(R.id.typed);

        for (int i=0; i<words.length; i++) {
            //compare typed word with the words array elements, if true, add +1 and remove from the array
            if (typed.getText().toString().equals(words[i])) {
                newScore = newScore + 1;
                //remove from array
                //removeElement(i);
                TextView scoreField = findViewById(R.id.score);
                scoreField.setText(String.valueOf(newScore));
                //make letters clickable
                makeLettersClickable();
                //clear typing field
                clearField();
            }
        }
    }

    //clear score
    private void clearScore (){
        TextView score = findViewById(R.id.score);
        score.setText("0");
    }

    //remove element from array
    private void removeElement(int i){
    }

    private void wrongAnswer (){
        Toast.makeText(this,"this is not a correct word", Toast.LENGTH_SHORT).show();
        makeLettersClickable();
        clearField();
    }




}
