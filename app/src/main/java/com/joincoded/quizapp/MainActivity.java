package com.joincoded.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView,
            correctAnswerTextView,
            wrongAnswerTextView;

    private Button trueButton,
            falseButton,
            nextQuestionButton;

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Boolean> answers = new ArrayList<>();

    private static int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setupQuestionsAndAnswers();

        displayQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
            }
        });

    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1)
            currentQuestionIndex++;
        else
            currentQuestionIndex = 0;

        displayQuestion();

        // Hide views
        correctAnswerTextView.setVisibility(View.INVISIBLE);
        nextQuestionButton.setVisibility(View.INVISIBLE);

        // Show views
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void initializeViews() {
        questionTextView = findViewById(R.id.questionTextView);
        correctAnswerTextView = findViewById(R.id.correctAnswerTextView);
        wrongAnswerTextView = findViewById(R.id.wrongAnswerTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
    }

    private void setupQuestionsAndAnswers() {
        questions.add("Do chickens fly 1?");
        answers.add(false);

        questions.add("Do chickens fly 2?");
        answers.add(false);

        questions.add("Do chickens fly 3?");
        answers.add(false);

        questions.add("Do chickens fly 4?");
        answers.add(false);

        questions.add("Do chickens fly 5?");
        answers.add(false);

        questions.add("Do chickens fly 6?");
        answers.add(false);

    }

    private void displayQuestion() {
        String currentQuestion = questions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion);
    }

    private void checkAnswer(boolean answer) {
        boolean currentAnswer = answers.get(currentQuestionIndex);
        if (currentAnswer == answer) {
            // Correct answer
            showCorrectAnswerViews();

        } else {
            // Wrong answer
            showWrongAnswerViews();
        }
    }

    private void showCorrectAnswerViews() {
        // Show views
        nextQuestionButton.setVisibility(View.VISIBLE);
        correctAnswerTextView.setVisibility(View.VISIBLE);

        // Hide views
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        wrongAnswerTextView.setVisibility(View.INVISIBLE);
    }

    private void showWrongAnswerViews() {
        // Hide views
        nextQuestionButton.setVisibility(View.INVISIBLE);
        correctAnswerTextView.setVisibility(View.INVISIBLE);

        // Show views
        wrongAnswerTextView.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);

    }


}