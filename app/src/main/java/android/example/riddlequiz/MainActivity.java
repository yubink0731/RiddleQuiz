package android.example.riddlequiz;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz3AnswerDisplayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitAnswer(View view) {

        int numberOfCorrectAnswer = 0;
        // Validate quiz 1
        RadioGroup quiz1RadioGroup = (RadioGroup) findViewById(R.id.quiz1_answer_radio_group);
        int selectedQuiz1Answer = quiz1RadioGroup.getCheckedRadioButtonId();
        Log.v(".MainActivity", "Radio1 Group: " + selectedQuiz1Answer);

        if (selectedQuiz1Answer == R.id.quiz1_radio_button4) {
            Log.v(".MainActivity", "Quiz1 correct answer");
            numberOfCorrectAnswer++;
//            numberOfCorrectAnswer = numberOfCorrectAnswer + 1;
//            numberOfCorrectAnswer += 1;
        }

        // Validate quiz 2
        EditText quiz2AnswerEditText = (EditText) findViewById(R.id.quiz2_answer_edit_text);
        String quiz2Answer = quiz2AnswerEditText.getText().toString();

        if (quiz2Answer.toLowerCase().contains("sleep")) {
            Log.v(".MainActivity", "Quiz2 correct answer");
            numberOfCorrectAnswer++;
        }

        // Validate quiz 3
        TextView quiz3AnswerTextView = (TextView) findViewById(R.id.quiz3_answer_textview);
        String quiz3Answer = quiz3AnswerTextView.getText().toString();

        if (quiz3Answer.equals("7")) {
            Log.v(".MainActivity", "Quiz3 correct answer");
            numberOfCorrectAnswer++;
        }

        // Validate quiz 4
        CheckBox quiz4AnswerCheckbox1 = (CheckBox) findViewById(R.id.quiz4_answer_checkbox1);
        CheckBox quiz4AnswerCheckbox2 = (CheckBox) findViewById(R.id.quiz4_answer_checkbox2);
        CheckBox quiz4AnswerCheckbox3 = (CheckBox) findViewById(R.id.quiz4_answer_checkbox3);

        if (quiz4AnswerCheckbox1.isChecked() &&
                !quiz4AnswerCheckbox2.isChecked() &&
                quiz4AnswerCheckbox3.isChecked()) {
            Log.v(".MainActivity", "Quiz4 correct answer");
            numberOfCorrectAnswer++;
        }

        // Validate quiz 5
        EditText quiz5AnswerEditText = (EditText) findViewById(R.id.quiz5_answer_edit_text);
        String quiz5Answer = quiz5AnswerEditText.getText().toString();

        if (quiz5Answer.toLowerCase().contains("hole")) {
            Log.v(".MainActivity", "Quiz5 correct answer");
            numberOfCorrectAnswer++;
        }

        // Validate quiz 6
        RadioGroup quiz6RadioGroup = (RadioGroup) findViewById(R.id.quiz6_answer_radio_group);
        int selectedQuiz6Answer = quiz6RadioGroup.getCheckedRadioButtonId();
        Log.v(".MainActivity", "Radio1 Group: " + selectedQuiz1Answer);

        if (selectedQuiz6Answer == R.id.quiz6_radio_button3) {
            Log.v(".MainActivity", "Quiz6 correct answer");
            numberOfCorrectAnswer++;
        }

        PopUpClass popUpClass = new PopUpClass();
        String finalResult;
        if (numberOfCorrectAnswer > 3) {
            finalResult = "Good job! You got " + numberOfCorrectAnswer + "/6 correct!";
        } else {
            finalResult = "You got " +numberOfCorrectAnswer + "/6 correct!";
        }

        popUpClass.showQuizResultWindow(view, finalResult);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void quiz3AnswerIncrement(View view) {
        if (quantity == 20) {
            Toast.makeText(this, "Try lower...", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        quiz3AnswerDisplayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void quiz3AnswerDecrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Try higher...", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        quiz3AnswerDisplayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void quiz3AnswerDisplayQuantity(int parameter) {
        TextView quantityTextView = (TextView) findViewById(R.id.quiz3_answer_textview);
        quantityTextView.setText("" + parameter);
    }

}