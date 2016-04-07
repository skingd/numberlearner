package stephen.greenrivertech.net.numberpushers;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Stephen on 4/7/2016.
 */
public class LearningModel {

    private int value1;
    private int value2;
    private int score = 0;
    private int tries = 0;
    TextView points;
    TextView attempts;
    private Random rand = new Random();



    public LearningModel(TextView points, TextView attempts){
        this.points = points;
        this.attempts = attempts;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(){
        score++;
    }

    public int getTries() {
        return tries;
    }

    public void increaseTries(){
        tries++;
    }



    /**
     * Toast
     */
    public void toasty(boolean isCorrect, Resources res, Context context) {
        //Resources res = getResources();
        //Context context = getApplicationContext();
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
    }

    /**
     * Check answer
     */
    public void CheckAnswer(int value, Button button1, Button button2, Resources res, Context context){
        if(value >= getValue1() && value >= getValue2()){
            UpdateScore();
            toasty(true, res, context);
        }else {
            toasty(false, res, context);
        }

        GenerateNumbers(button1, button2);
    }

    /**
     * Update Score
     */
    public void UpdateScore(){
        String val;
        increaseScore();
        val = String.valueOf(getScore());
        points.setText(val);
    }

    /**
     * Update Attempts
     */
    public void UpdateAttempts(){
        String val;
        increaseTries();
        val = String.valueOf(getTries());
        attempts.setText(val);
    }

    /**
     * Generate Random Numbers
     */
    public void GenerateNumbers(Button button1, Button button2){
        value1 = rand.nextInt(11);
        value2 = rand.nextInt(11);
        String value = String.valueOf(value1);
        button1.setText(value);
        value = String.valueOf(value2);
        button2.setText(value);
    }
}
