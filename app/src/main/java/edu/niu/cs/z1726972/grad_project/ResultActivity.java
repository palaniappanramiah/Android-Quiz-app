/******************************************************************
 * Name           : Palaniappan Ramiah
 * ZID            : Z1726972
 * Class          : Android
 * Assignment No. : Graduate Project
 * Program Name   : ResultActivity.java
 * Description    : Db class to store the questions
 * Due Date       : 04/30/2015 11:59:59 pm
******************************************************************/

package edu.niu.cs.z1726972.grad_project;

// Importing all the required packages
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener{

    // Declaring the objects and components
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar); // Get the  rating bar object
        TextView textView = (TextView) findViewById(R.id.textResult); // Get the text view result
        Bundle b = getIntent().getExtras();
        buttonNext = (Button) findViewById(R.id.button);
        int score = b.getInt("score"); // Get the score
        bar.setRating(score); // Set the rating according to the score

        switch (score) {
            case 0:
                textView.setText("Better luck, next time!");
                break;

            case 1:
            case 2:
                textView.setText("Not Bad!");
                break;

            case 3:
            case 4:
                textView.setText("Good Attempt!");
                break;

            case 5:
                textView.setText("Congrats, Champ!");
                break;
        }

        // When the next button is clicked
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
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