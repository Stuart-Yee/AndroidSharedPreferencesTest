package com.stuartyee.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        DisplaySavedText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                DisplayAndSaveText(enteredText);
            }
        });

    }

    private void DisplaySavedText() {

        //Reading and retriving the value from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(
                "MySharedPref",
                MODE_PRIVATE);

        // First parameter for getString is the key, second is the default value if the
        // key doesn't exist.
        String s1 = sharedPreferences.getString("name", "No Preferences Set");

        textView.setText(s1);
    }

    private  void DisplayAndSaveText(String enteredText){
        textView.setText(enteredText);

        // Here's the shared preferences
        SharedPreferences sharedPreferences =
                getSharedPreferences(
                        "MySharedPref",
                        MODE_PRIVATE
                        );
        // Writing data to MySharedPref
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // use a put method to add a key/value pair
        editor.putString("name", enteredText);

        // need to execute method to save changes;
        editor.commit();

    }
}