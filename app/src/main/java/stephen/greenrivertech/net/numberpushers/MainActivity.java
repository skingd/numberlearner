package stephen.greenrivertech.net.numberpushers;
/**
 * Number Learning App
 * Author: Stephen King
 * Version: 1.0
 */


import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Variables
    private Random rand = new Random();
    private Button button1;
    private Button button2;
    private int value1;
    private int value2;
    private int score = 0;
    private int tries = 0;
    private TextView points;
    private TextView attempts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Instantiate buttons
        button1 = (Button)findViewById(R.id.Button1);
        button2 = (Button)findViewById(R.id.Button2);

        //Instantiate points display
        points = (TextView)findViewById(R.id.point_display);
        attempts = (TextView)findViewById(R.id.attempt_display);
        //Create initial random number set
        GenerateNumbers();

        //Set click listener for button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrect;
                CheckAnswer(value1);

            }
        });

        //Set click listener for button1
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrect;
                CheckAnswer(value2);

            }
        });

    }

    /**
     * Toast
     */
    private void toasty(boolean isCorrect) {
        Resources res = getResources();
        Context context = getApplicationContext();
        CharSequence text = "I'm Broken! :S";

        if (isCorrect) {
            text = res.getString(R.string.correct);
        }else if(!isCorrect) {
            text = res.getString(R.string.wrong);
        }
        int duration = Toast.LENGTH_SHORT;

        //TOAST!
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        UpdateAttempts();
        GenerateNumbers();
    }


    /**
     * Generate Random Numbers
     */
    private void GenerateNumbers(){
        value1 = rand.nextInt(11);
        value2 = rand.nextInt(11);
        String value = String.valueOf(value1);
        button1.setText(value);
        value = String.valueOf(value2);
        button2.setText(value);
    }

    /**
     * Check answer
     */
    private void CheckAnswer(int value){
        if(value >= value1 && value >= value2){
            UpdateScore();
            toasty(true);
        }else {
            toasty(false);
        }
    }

    /**
     * Update Score
     */

    public void UpdateScore(){
        String val;
        score++;
        val = String.valueOf(score);
        points.setText(val);
    }

    /**
     * Update Attempts
     */
    public void UpdateAttempts(){
        String val;
        tries++;
        val = String.valueOf(tries);
        attempts.setText(val);
    }
}
