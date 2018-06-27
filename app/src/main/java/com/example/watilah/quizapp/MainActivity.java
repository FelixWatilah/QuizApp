package com.example.watilah.quizapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name;
    RadioButton qnOneA, qnOneB, qnOneC, qnOneD, qnTwoA, qnTwoB, qnTwoC, qnTwoD, qnFourA, qnFourB, qnFourC, qnFourD, qnSixA, qnSixB, qnSixC, qnSixD, qnEightA, qnEightB, qnEightC, qnEightD, qnNineA, qnNineB, qnNineC, qnNineD;
    CheckBox qnThreeA, qnThreeB, qnThreeC, qnThreeD, qnFiveA, qnFiveB, qnFiveC, qnFiveD;
    EditText qnSeven, qnTen;
    RadioGroup rgOne, rgTwo, rgFour, rgSix, rgEight, rgNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgOne = findViewById(R.id.rgOne);
        rgTwo = findViewById(R.id.rgTwo);
        rgFour = findViewById(R.id.rgFour);
        rgSix = findViewById(R.id.rgSix);
        rgEight = findViewById(R.id.rgEight);
        rgNine = findViewById(R.id.rgNine);

        // Getting the Id of the student name
        name = findViewById(R.id.name);

        // Getting IDs of the Checkboxes, RadioButtons, and EditTexts
        qnOneA = findViewById(R.id.oneA);
        qnOneB = findViewById(R.id.oneB);
        qnOneC = findViewById(R.id.oneC);
        qnOneD = findViewById(R.id.oneD);
        qnTwoA = findViewById(R.id.twoA);
        qnTwoB = findViewById(R.id.twoB);
        qnTwoC = findViewById(R.id.twoC);
        qnTwoD = findViewById(R.id.twoD);
        qnThreeA = findViewById(R.id.cbthreeA);
        qnThreeB = findViewById(R.id.cbthreeB);
        qnThreeC = findViewById(R.id.cbthreeC);
        qnThreeD = findViewById(R.id.cbthreeD);
        qnFourA = findViewById(R.id.fourA);
        qnFourB = findViewById(R.id.fourB);
        qnFourC = findViewById(R.id.fourC);
        qnFourD = findViewById(R.id.fourD);
        qnFiveA = findViewById(R.id.cbfiveA);
        qnFiveB = findViewById(R.id.cbfiveB);
        qnFiveC = findViewById(R.id.cbfiveC);
        qnFiveD = findViewById(R.id.cbfiveD);
        qnSixA = findViewById(R.id.sixA);
        qnSixB = findViewById(R.id.sixB);
        qnSixC = findViewById(R.id.sixC);
        qnSixD = findViewById(R.id.sixD);
        qnSeven = findViewById(R.id.seven);
        qnEightA = findViewById(R.id.eightA);
        qnEightB = findViewById(R.id.eightB);
        qnEightC = findViewById(R.id.eightC);
        qnEightD = findViewById(R.id.eightD);
        qnNineA = findViewById(R.id.nineA);
        qnNineB = findViewById(R.id.nineB);
        qnNineC = findViewById(R.id.nineC);
        qnNineD = findViewById(R.id.nineD);
        qnTen = findViewById(R.id.ten);

    }

    public void submitAnswers(View view) {

        // Student Name
        String studentName = name.getText().toString().trim();

        String one, two, three, four, five, six, seven, eight, nine, ten;

        // Calling methods with answers.
        one = questionOne(view);
        two = questionTwo(view);
        three = questionThree(view);
        four = questionFour(view);
        five = questionFive(view);
        six = questionSix(view);
        seven = questionSeven(view);
        eight = questionEight(view);
        nine = questionNine(view);
        ten = questionTen(view);

        // Check of the questions are not null.
        if (one.equals("") || two.equals("") || three.equals("") || four.equals("") || five.equals("") || six.equals("") || seven.equals("") || eight.equals("") || nine.equals("") || ten.equals("")) {
            // Display Error Toast
            Toast.makeText(getApplicationContext(), "Please answer all the questions before submitting.", Toast.LENGTH_LONG).show();
        } else if (studentName.equals("")) {
            // Display Error Toast
            Toast.makeText(getApplicationContext(), "Please ensure you enter your name before submitting your answer.", Toast.LENGTH_LONG).show();
        } else {
            // Pass correct scores to showConfirmDialog.
            showConfirmDialog(view, studentName, one, two, three, four, five, six, seven, eight, nine, ten);
        }

    }

    public void showConfirmDialog(final View view, final String studentName, final String one, final String two, final String three, final String four, final String five, final String six, final String seven, final String eight, final String nine, final String ten) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Submit Answers");
        builder.setMessage("Are you sure you want to submit your answers?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Assignment of correct scores
                String cor_one, cor_two, cor_three, cor_four, cor_five, cor_six, cor_seven, cor_eight, cor_nine, cor_ten;

                cor_one = "Paused state";
                cor_two = "XML and Java";
                cor_three = "Dalvik Executable, Resources, Native Libraries";
                cor_four = "Content provider";
                cor_five = "AlertDialog, ProgressDialog, DatePickerDialog, BottomSheetDialog";
                cor_six = "Manifest file";
                cor_seven = "strings.xml";
                cor_eight = "All three options will work";
                cor_nine = "contentProvider";
                cor_ten = "finish()";

                // Check if the answer provided by the Student is correct. If the
                // answer is correct, we award 1 point, else we award 0.
                int score, score_one, score_two, score_three, score_four, score_five, score_six, score_seven, score_eight, score_nine, score_ten;

                if (one.equals(cor_one)) {
                    score_one = 1;
                } else {
                    score_one = 0;
                }

                if (two.equals(cor_two)) {
                    score_two = 1;
                } else {
                    score_two = 0;
                }

                if (three.equals(cor_three)) {
                    score_three = 1;
                } else {
                    score_three = 0;
                }

                if (four.equals(cor_four)) {
                    score_four = 1;
                } else {
                    score_four = 0;
                }

                if (five.equals(cor_five)) {
                    score_five = 1;
                } else {
                    score_five = 0;
                }

                if (six.equals(cor_six)) {
                    score_six = 1;
                } else {
                    score_six = 0;
                }

                if (seven.equals(cor_seven)) {
                    score_seven = 1;
                } else {
                    score_seven = 0;
                }

                if (eight.equals(cor_eight)) {
                    score_eight = 1;
                } else {
                    score_eight = 0;
                }

                if (nine.equals(cor_nine)) {
                    score_nine = 1;
                } else {
                    score_nine = 0;
                }

                if (ten.equals(cor_ten)) {
                    score_ten = 1;
                } else {
                    score_ten = 0;
                }

                // Calculate Total Score
                score = score_one + score_two + score_three + score_four + score_five + score_six + score_seven + score_eight + score_nine + score_ten;

                // Convert score to String
                String totalScore = String.valueOf(score).trim();

                // Display Results
                Toast.makeText(getApplicationContext(), "Name: " + studentName + "\nScore: " + totalScore + "/10\n\nQ1: " + one + "\nQ2: " + two + "\nQ3: " + three + "\nQ4: " + four + "\nQ5: " + five + "\nQ6: " + six + "\nQ7: " + seven + "\nQ8: " + eight + "\nQ9: " + nine + "\nQ10: " + ten, Toast.LENGTH_LONG).show();

                // Pass correct values of question Seven and Ten to showResultsDialog
                showResultsDialog(cor_seven, cor_ten);

            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Retry.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    // A Dialog to know whether a student should retry or view answers
    public void showResultsDialog(final String ans_seven, final String ans_ten) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Results");
        builder.setMessage("Would you like to Retry or view the correct answers?");
        builder.setIcon(R.drawable.ic_warning_black_24dp);
        builder.setPositiveButton("View Answers", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Assigning values to Checkboxes, RadioButtons and EditTexts
                qnOneC.setChecked(true);
                qnTwoB.setChecked(true);
                qnThreeA.setChecked(true);
                qnThreeB.setChecked(true);
                qnThreeC.setChecked(true);
                qnFourB.setChecked(true);
                qnFiveA.setChecked(true);
                qnFiveB.setChecked(true);
                qnFiveC.setChecked(true);
                qnFiveD.setChecked(true);
                qnSixD.setChecked(true);
                qnSeven.setText(ans_seven);
                qnEightD.setChecked(true);
                qnNineC.setChecked(true);
                qnTen.setText(ans_ten);

                Toast.makeText(getApplicationContext(), "These are the expected answers.", Toast.LENGTH_LONG).show();

            }
        }).setNegativeButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetViews();
            }
        });

        builder.create().show();
    }

    // Resetting the views, to allow a student to enter answers
    public void resetViews() {

        // get selected radio button from radioGroup
        int selectedIdOne = rgOne.getCheckedRadioButtonId();
        int selectedIdTwo = rgTwo.getCheckedRadioButtonId();
        int selectedIdFour = rgFour.getCheckedRadioButtonId();
        int selectedIdSix = rgSix.getCheckedRadioButtonId();
        int selectedIdEight = rgEight.getCheckedRadioButtonId();
        int selectedIdNine = rgNine.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbOne = findViewById(selectedIdOne);
        RadioButton rbTwo = findViewById(selectedIdTwo);
        RadioButton rbFour = findViewById(selectedIdFour);
        RadioButton rbSix = findViewById(selectedIdSix);
        RadioButton rbEight = findViewById(selectedIdEight);
        RadioButton rbNine = findViewById(selectedIdNine);

        rbOne.setChecked(false);
        rbTwo.setChecked(false);
        qnThreeA.setChecked(false);
        qnThreeB.setChecked(false);
        qnThreeC.setChecked(false);
        qnThreeD.setChecked(false);
        rbFour.setChecked(false);
        qnFiveA.setChecked(false);
        qnFiveB.setChecked(false);
        qnFiveC.setChecked(false);
        qnFiveD.setChecked(false);
        rbSix.setChecked(false);
        qnSeven.setText("");
        rbEight.setChecked(false);
        rbNine.setChecked(false);
        qnTen.setText("");

        Toast.makeText(getApplicationContext(), "Boom! Here is another chance for you to try.", Toast.LENGTH_LONG).show();
    }

    // Method to get the value of Question One
    public String questionOne(View view) {

        String result;

        RadioGroup rgOne = findViewById(R.id.rgOne);

        // get selected radio button from radioGroup
        int selectedId = rgOne.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbOne = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbOne.getText().toString();
        }

        return result;

    }

    // Method to get the value of Question Two
    public String questionTwo(View view) {

        String result;

        RadioGroup rgTwo = findViewById(R.id.rgTwo);

        // get selected radio button from radioGroup
        int selectedId = rgTwo.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbTwo = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbTwo.getText().toString();
        }

        return result;

    }

    // Method to get the value of Question Three
    public String questionThree(View view) {

        CheckBox cbthreeA = findViewById(R.id.cbthreeA);
        CheckBox cbthreeB = findViewById(R.id.cbthreeB);
        CheckBox cbthreeC = findViewById(R.id.cbthreeC);
        CheckBox cbthreeD = findViewById(R.id.cbthreeD);

        String A = cbthreeA.getText().toString();
        String B = cbthreeB.getText().toString();
        String C = cbthreeC.getText().toString();
        String D = cbthreeD.getText().toString();

        // result variable to hold the values of the checked checkboxes
        String result;

        if (cbthreeA.isChecked() && cbthreeB.isChecked() && cbthreeC.isChecked() && cbthreeD.isChecked()) {
            result = A + ", " + B + ", " + C + ", " + D;
        } else if (cbthreeA.isChecked() && cbthreeB.isChecked() && cbthreeC.isChecked()) {
            result = A + ", " + B + ", " + C;
        } else if (cbthreeA.isChecked() && cbthreeB.isChecked() && cbthreeD.isChecked()) {
            result = A + ", " + B + ", " + D;
        } else if (cbthreeA.isChecked() && cbthreeC.isChecked() && cbthreeD.isChecked()) {
            result = A + ", " + C + ", " + D;
        } else if (cbthreeB.isChecked() && cbthreeC.isChecked() && cbthreeD.isChecked()) {
            result = B + ", " + C + ", " + D;
        } else if (cbthreeA.isChecked() && cbthreeB.isChecked()) {
            result = A + ", " + B;
        } else if (cbthreeA.isChecked() && cbthreeC.isChecked()) {
            result = A + ", " + C;
        } else if (cbthreeA.isChecked() && cbthreeD.isChecked()) {
            result = A + ", " + D;
        } else if (cbthreeB.isChecked() && cbthreeC.isChecked()) {
            result = B + ", " + C;
        } else if (cbthreeB.isChecked() && cbthreeD.isChecked()) {
            result = B + ", " + D;
        } else if (cbthreeC.isChecked() && cbthreeD.isChecked()) {
            result = C + ", " + D;
        } else if (cbthreeA.isChecked()) {
            result = A;
        } else if (cbthreeB.isChecked()) {
            result = B;
        } else if (cbthreeC.isChecked()) {
            result = C;
        } else if (cbthreeD.isChecked()) {
            result = D;
        } else {
            result = "";
        }
        return result;

    }

    // Method to get the value of Question Four
    public String questionFour(View view) {

        String result;

        RadioGroup rgFour = findViewById(R.id.rgFour);

        // get selected radio button from radioGroup
        int selectedId = rgFour.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbFour = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbFour.getText().toString();
        }

        return result;

    }

    // Method to get the value of Question Five
    public String questionFive(View view) {

        CheckBox cbfiveA = findViewById(R.id.cbfiveA);
        CheckBox cbfiveB = findViewById(R.id.cbfiveB);
        CheckBox cbfiveC = findViewById(R.id.cbfiveC);
        CheckBox cbfiveD = findViewById(R.id.cbfiveD);

        String A = cbfiveA.getText().toString();
        String B = cbfiveB.getText().toString();
        String C = cbfiveC.getText().toString();
        String D = cbfiveD.getText().toString();

        // result variable to hold values of the checked checkboxes
        String result;

        if (cbfiveA.isChecked() && cbfiveB.isChecked() && cbfiveC.isChecked() && cbfiveD.isChecked()) {
            result = A + ", " + B + ", " + C + ", " + D;
        } else if (cbfiveA.isChecked() && cbfiveB.isChecked() && cbfiveC.isChecked()) {
            result = A + ", " + B + ", " + C;
        } else if (cbfiveA.isChecked() && cbfiveB.isChecked() && cbfiveD.isChecked()) {
            result = A + ", " + B + ", " + D;
        } else if (cbfiveA.isChecked() && cbfiveC.isChecked() && cbfiveD.isChecked()) {
            result = A + ", " + C + ", " + D;
        } else if (cbfiveB.isChecked() && cbfiveC.isChecked() && cbfiveD.isChecked()) {
            result = B + ", " + C + ", " + D;
        } else if (cbfiveA.isChecked() && cbfiveB.isChecked()) {
            result = A + ", " + B;
        } else if (cbfiveA.isChecked() && cbfiveC.isChecked()) {
            result = A + ", " + C;
        } else if (cbfiveA.isChecked() && cbfiveD.isChecked()) {
            result = A + ", " + D;
        } else if (cbfiveB.isChecked() && cbfiveC.isChecked()) {
            result = B + ", " + C;
        } else if (cbfiveB.isChecked() && cbfiveD.isChecked()) {
            result = B + ", " + D;
        } else if (cbfiveC.isChecked() && cbfiveD.isChecked()) {
            result = C + ", " + D;
        } else if (cbfiveA.isChecked()) {
            result = A;
        } else if (cbfiveB.isChecked()) {
            result = B;
        } else if (cbfiveC.isChecked()) {
            result = C;
        } else if (cbfiveD.isChecked()) {
            result = D;
        } else if (cbfiveA.isChecked() && cbfiveB.isChecked()) {
            result = A + ", " + B;
        } else {
            result = "";
        }
        return result;
    }

    // Method to get the value of Question Six
    public String questionSix(View view) {

        String result;

        RadioGroup rgSix = findViewById(R.id.rgSix);

        // get selected radio button from radioGroup
        int selectedId = rgSix.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbSix = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbSix.getText().toString();
        }

        return result;

    }

    // Method to get the value of Question Seven
    public String questionSeven(View view) {

        String result;

        TextView seven = findViewById(R.id.seven);

        if (seven.getText().toString().trim().equals("")) {
            result = "";
        } else {
            result = seven.getText().toString().trim();
        }

        return result;

    }

    // Method to get the value of Question Eight
    public String questionEight(View view) {

        String result;

        RadioGroup rgEight = findViewById(R.id.rgEight);

        // get selected radio button from radioGroup
        int selectedId = rgEight.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbEight = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbEight.getText().toString();
        }

        return result;
    }

    // Method to get the value of Question Nine
    public String questionNine(View view) {

        String result;

        RadioGroup rgNine = findViewById(R.id.rgNine);

        // get selected radio button from radioGroup
        int selectedId = rgNine.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton rbNine = findViewById(selectedId);

        if (selectedId == -1) {
            result = "";
        } else {
            result = rbNine.getText().toString();
        }

        return result;
    }

    // Method to get the value of Question Ten
    public String questionTen(View view) {

        String result;

        TextView ten = findViewById(R.id.ten);

        if (ten.getText().toString().trim().equals("")) {
            result = "";
        } else {
            result = ten.getText().toString().trim();
        }

        return result;
    }

}