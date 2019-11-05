/*
Why wait?
*/
package com.example.asakura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Test_Dialog.ExampleDialogListeners {
    //Objects to configure the TextView and Button in the MainActivity
    TextView textViewEntered;
    TextView textViewResponse;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewEntered = (TextView) findViewById(R.id.text_entered); //TextView
        textViewResponse = (TextView) findViewById(R.id.response_text);
        button = (Button) findViewById(R.id.button);                  //Button
        
        //Method which configures what happens when the button is clicked
        //In this case, the openDialog() method is invoked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();   
            }
        });
    }

    public void openDialog() {
        Test_Dialog testDialog = new Test_Dialog();
        testDialog.show(getSupportFragmentManager(), "A test dialog");
    }

    //A method which will apply passed Strings to a TextView us
    public void applyTexts(String input) {
        textViewEntered.setText(input);
                if(input.equals("black"))
                    textViewResponse.setText("black");
    }
}
