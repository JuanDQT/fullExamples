package com.example.juandaniel.practicas.conSharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.juandaniel.practicas.R;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private Button clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        clean = (Button) findViewById(R.id.btnClean);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.editText);


        button.setOnClickListener(view -> {
            if (editText.getText().toString().length() > 0) {

                //Lo guardamos
                addPreferenceValue(Constants.SP_NAME, editText.getText().toString());
                //Lo cargamos
                textView.setText(getPreferenceValue(Constants.SP_NAME));

            }
        });

        clean.setOnClickListener(view -> cleanSharedPreferences());



    }

    public void addPreferenceValue(String key, String value) {
        SharedPreferences.Editor sharedPreferenceEditor = getSharedPreferences(Constants.SHARED_PREFERENCES_BASE_NAME, MODE_PRIVATE).edit();
        sharedPreferenceEditor.putString(key, value);
        sharedPreferenceEditor.apply();

    }

    public String getPreferenceValue(String string) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_BASE_NAME, MODE_PRIVATE);
        return sharedPreferences.getString(string, "Sin valores");
    }

    public void cleanSharedPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.SHARED_PREFERENCES_BASE_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();

        textView.setText(getPreferenceValue(Constants.SP_NAME));
    }
}

