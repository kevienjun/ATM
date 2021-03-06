package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText edGender;
    private int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next(View view){
        edGender = findViewById(R.id.ed_gender);
        gender = Integer.parseInt(edGender.getText().toString());
        getSharedPreferences("user",MODE_PRIVATE)
                .edit()
                .putInt("USERGENDER",gender)
                .apply();
        Intent mainactivity = new Intent(this,MainActivity.class);
        setResult(RESULT_OK);
        mainactivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(mainactivity);
    }
    public void back(View view){
        finish();
    }
}