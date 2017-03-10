package andriodproject.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean correctAnswer_Question1 = true;
    boolean correctAnswer_Question2 = false;
    boolean correctAnswer_Question3 = true;
    boolean correctAnswer_Question4 = true;
    boolean correctAnswer_Question5 = false;
    boolean correctAnswer_Question6 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitResult(View v) {

        String name =  ((EditText)findViewById(R.id.nameText)).getText().toString();
        Boolean IsMale_gender = ((RadioButton) findViewById(R.id.male)).isChecked();
        Boolean IsFemale_gender = ((RadioButton) findViewById(R.id.female)).isChecked();
        Boolean answerQ1 = ((CheckBox) findViewById(R.id.CheckBoxQ1)).isChecked();
        Boolean answerQ2 = ((CheckBox) findViewById(R.id.CheckBoxQ2)).isChecked();
        Boolean answerQ3 = ((CheckBox) findViewById(R.id.CheckBoxQ3)).isChecked();
        Boolean answerQ4 = ((CheckBox) findViewById(R.id.CheckBoxQ4)).isChecked();
        Boolean answerQ5 = ((CheckBox) findViewById(R.id.CheckBoxQ5)).isChecked();
        Boolean answerQ6 = ((CheckBox) findViewById(R.id.CheckBoxQ6)).isChecked();

        int score = getScore(answerQ1, answerQ2, answerQ3, answerQ4, answerQ5, answerQ6);
        String result, helloMsg;
        if (score == 6)
            result = "Congrats.. You answered all of them correctly :)";
        else if (score == 0)
            result = "Please answer the questions to view your results. ";
        else
            result = "You answered " + score + " out of 6 correctly.";

        if (IsMale_gender)
            helloMsg = "Hello, Mr." + name;
        else if (IsFemale_gender)
            helloMsg = "Hello, Ms." + name;
        else
            helloMsg = "Hello there";

        Toast.makeText(MainActivity.this, helloMsg, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
    }

    private int getScore(Boolean answerQ1, Boolean answerQ2, Boolean answerQ3, Boolean answerQ4, Boolean answerQ5, Boolean answerQ6) {

        int score = 0;

        if (answerQ1 == correctAnswer_Question1)
            score = score + 1;
        if (answerQ2 == correctAnswer_Question2)
            score = score + 1;
        if (answerQ3 == correctAnswer_Question3)
            score = score + 1;
        if (answerQ4 == correctAnswer_Question4)
            score = score + 1;
        if (answerQ5 == correctAnswer_Question5)
            score = score + 1;
        if (answerQ6 == correctAnswer_Question6)
            score = score + 1;

        return score;
    }


}
