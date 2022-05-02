package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    EditText edtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edtInput);
        edtLog = findViewById(R.id.edtLog);

    }

    public void onClickButton01(View view){

        String textoEdtInput = edtInput.getText().toString();
        edtInput.setText("");

        String textoEdtLog = edtLog.getText().toString();
        textoEdtLog += " - " + textoEdtInput;

        edtLog.setText(textoEdtLog);

        Log.d("MainActivity", textoEdtInput);
    }
}