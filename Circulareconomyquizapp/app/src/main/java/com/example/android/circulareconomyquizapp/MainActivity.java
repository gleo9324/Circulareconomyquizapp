package com.example.android.circulareconomyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "Done!" button is clicked.
     */
    public void submitAnswer(View view) {
        /**
         * This method calculates the score
         */
        int score = calculateScore();

        /**
         * This instructions display the score message with a toast
         */
        String scoreText;
        if (score > 10) {
            scoreText = getString(R.string.score) + score + getString(R.string.best_score);
        } else if (score > 5) {
            scoreText = getString(R.string.score) + score + getString(R.string.medium_score);
        } else {
            scoreText = getString(R.string.score) + score + getString(R.string.low_score);
        }

        Spannable centeredText = new SpannableString(scoreText);
        centeredText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                0, scoreText.length() - 1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        Toast.makeText(this, centeredText, Toast.LENGTH_LONG).show();
    }

    /**
     * This method calculates the quiz score.
     * Right answer for radio buttons: 3 points
     * Right answer for free answer: 3 points
     * Right answer for check boxes: 1 point each right check box
     */
    private int calculateScore() {
        int score = 0;

        /**
         * First question: the right answer is Aluminium (in position 3)
         */
        RadioGroup groupQuestionOne = (RadioGroup) findViewById(R.id.question_one);
        int idAnswerOne = groupQuestionOne.getCheckedRadioButtonId();

        if (idAnswerOne == findViewById(R.id.question_one_three).getId()) {
            score += 3;
        }

        /**
         * Second question: the right answers are Mint, Rosemary, and Basil
         */
        CheckBox checkQ2A1 = (CheckBox) findViewById(R.id.q_two_one_checkbox);
        CheckBox checkQ2A2 = (CheckBox) findViewById(R.id.q_two_two_checkbox);
        CheckBox checkQ2A3 = (CheckBox) findViewById(R.id.q_two_three_checkbox);
        CheckBox checkQ2A4 = (CheckBox) findViewById(R.id.q_two_four_checkbox);
        CheckBox checkQ2A5 = (CheckBox) findViewById(R.id.q_two_five_checkbox);

        boolean isQ2A1 = checkQ2A1.isChecked();
        boolean isQ2A2 = checkQ2A2.isChecked();
        boolean isQ2A3 = checkQ2A3.isChecked();
        boolean isQ2A4 = checkQ2A4.isChecked();
        boolean isQ2A5 = checkQ2A5.isChecked();

        if (isQ2A2 | isQ2A5){

        }
        else {
            if (isQ2A1 & isQ2A3 & isQ2A4) {
                score += 3;
            } else if ((isQ2A1 & isQ2A3) | (isQ2A1 & isQ2A4) | (isQ2A3 & isQ2A4)) {
                score += 2;
            } else if (isQ2A1 | isQ2A3 | isQ2A4) {
                score += 1;
            }
        }

        /**
         * Third question: the right answers are in position 2, 4, 5
         */
        CheckBox checkQ3A1 = (CheckBox) findViewById(R.id.q_three_one_checkbox);
        CheckBox checkQ3A2 = (CheckBox) findViewById(R.id.q_three_two_checkbox);
        CheckBox checkQ3A3 = (CheckBox) findViewById(R.id.q_three_three_checkbox);
        CheckBox checkQ3A4 = (CheckBox) findViewById(R.id.q_three_four_checkbox);
        CheckBox checkQ3A5 = (CheckBox) findViewById(R.id.q_three_five_checkbox);
        CheckBox checkQ3A6 = (CheckBox) findViewById(R.id.q_three_six_checkbox);

        boolean isQ3A1 = checkQ3A1.isChecked();
        boolean isQ3A2 = checkQ3A2.isChecked();
        boolean isQ3A3 = checkQ3A3.isChecked();
        boolean isQ3A4 = checkQ3A4.isChecked();
        boolean isQ3A5 = checkQ3A5.isChecked();
        boolean isQ3A6 = checkQ3A6.isChecked();

        if (isQ3A1 | isQ3A3 | isQ3A6){

        }else {
            if (isQ3A2 & isQ3A4 & isQ3A5) {
                score += 3;
            } else if ((isQ3A2 & isQ3A4) | (isQ3A2 & isQ3A5) | (isQ3A4 & isQ3A5)) {
                score += 2;
            } else if (isQ3A2 | isQ3A4 | isQ3A5) {
                score += 1;
            }
        }

        /**
         * Fourth question: the right answers is Plastic
         */
        EditText polystyreneView = findViewById(R.id.polystyrene_edit_view);
        String polystyrene = polystyreneView.getText().toString();

        if (polystyrene.equalsIgnoreCase("Plastic")) {
            score += 3;
        }

        /**
         * Fift question: the right answer is 17 (in position 2)
         */
        RadioGroup questionFive = (RadioGroup) findViewById(R.id.question_five);
        int idAnswerFive = questionFive.getCheckedRadioButtonId();

        if (idAnswerFive == findViewById(R.id.question_five_two).getId()) {
            score += 3;
        }

        return score;
    }
}