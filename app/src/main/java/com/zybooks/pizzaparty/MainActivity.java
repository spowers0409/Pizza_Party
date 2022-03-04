package com.zybooks.pizzaparty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    public final int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign widgets to the field
        mNumAttendEditText = findViewById(R.id.attendEditText);
        mNumPizzasTextView = findViewById(R.id.answerTextView);
        mHowHungryRadioGroup = findViewById(R.id.hungryRadioGroup);
    }

    public void calculateClick(View view) {
        // Get the text that was typed into the EditText
        String numAttendStr = mNumAttendEditText.getText().toString();

        // Convert the text into an integer
        int numAttend = Integer.parseInt(numAttendStr);

        // Determine how many slices on average each person will eat
        int slicesPerPerson = 0;
        int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
        if(checkedId == R.id.lightRadioButton) {
            slicesPerPerson = 2;
        }
        else if (checkedId == R.id.mediumRadioButton) {
            slicesPerPerson = 3;
        }
        else if (checkedId == R.id.ravenousRadioButton) {
            slicesPerPerson = 4;
        }

        // Calculate and show the number of pizzas needed
        int totalPizzas = (int)Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}