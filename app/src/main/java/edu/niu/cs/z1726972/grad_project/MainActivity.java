/******************************************************************
 * Name           : Palaniappan Ramiah
 * ZID            : Z1726972
 * Class          : Android
 * Assignment No. : Graduate Project
 * Program Name   : MainActivity.java
 * Description    : Quiz app
 * Due Date       : 04/30/2015 11:59:59 pm
 *****************************************************************/

package edu.niu.cs.z1726972.grad_project;

// Importing all the required packages
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    // Declaring the objects and components
    List<Question> questionsList;
    List<Integer> previousQueList = new ArrayList<Integer>();
    int questionId = 0, score = 0, questionNum = 1;
    Question currentQuestion;
    TextView textQuestion;
    RadioButton radioA, radioB, radioC, radioD;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the objects to each components of the view
        textQuestion = (TextView)findViewById(R.id.textView);
        radioA = (RadioButton)findViewById(R.id.radioA);
        radioB = (RadioButton)findViewById(R.id.radioB);
        radioC = (RadioButton)findViewById(R.id.radioC);
        radioD = (RadioButton)findViewById(R.id.radioD);
        buttonNext = (Button)findViewById(R.id.button);

        // Creating object for DbAdapter, fetching and displaying questions from DB
        DbAdapter db = new DbAdapter(this);
        questionsList = db.getAllQuestions();
        currentQuestion = questionsList.get(questionId);
        setQuestionView();
        previousQueList.clear();

        // When the next button is clicked
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fetching the choices and the selected answer for the current question
                RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
                RadioButton selectedAnswer = (RadioButton)findViewById(group.getCheckedRadioButtonId());

                // Incrementing the score if the selected choice matches the correct answer
                if(currentQuestion.getAnswer().equals(selectedAnswer.getText()))
                    score++;

                // Displaying the next question
                if(questionId < 5){
                    currentQuestion = questionsList.get(questionId);
                    setQuestionView();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); // Putting the score in the bundle
                    intent.putExtras(b); // Pass the score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Method to display the question and choices
    private void setQuestionView()
    {
        textQuestion.setText(questionNum++ + ". " +currentQuestion.getQuestion());
        radioA.setText(currentQuestion.getOptionA());
        radioB.setText(currentQuestion.getOptionB());
        radioC.setText(currentQuestion.getOptionC());
        radioD.setText(currentQuestion.getOptionD());
        questionId++; // Incrementing for the next question
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
    }
}