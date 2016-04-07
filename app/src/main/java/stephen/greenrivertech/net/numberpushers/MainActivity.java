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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Variables
    private Button button1;
    private Button button2;
    private TextView points;
    private TextView attempts;
    private LearningModel m_lModel;


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

        //Instantiate model
        m_lModel= new LearningModel(points, attempts);

        //Create initial random number set
        m_lModel.GenerateNumbers(button1, button2);

        //Set click listener for button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrect;
                m_lModel.CheckAnswer(m_lModel.getValue1(), button1, button2, getResources(), getApplicationContext());

            }
        });

        //Set click listener for button1
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCorrect;
                m_lModel.CheckAnswer(m_lModel.getValue2(), button1, button2, getResources(), getApplicationContext());

            }
        });

    }





}
