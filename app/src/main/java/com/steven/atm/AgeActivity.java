package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {

    private EditText edAge;
    private int age;
    int [] ageChoose = {1,2,3,4,5,6,7,8,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView ageRecycler = findViewById(R.id.recycler);
        ageRecycler.setHasFixedSize(true);
        ageRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    public void next(View view){
        edAge = findViewById(R.id.ed_age);
        age = Integer.parseInt(edAge.getText().toString());
        getSharedPreferences("user",MODE_PRIVATE)
                .edit()
                .putInt("USERAGE", age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view){
        finish();
    }

    class ageAdapter {
        class ageViewAdapter extends RecyclerView.ViewHolder{
            TextView ageText;
            public ageViewAdapter(View itemView) {
                super(itemView);
                ageText = itemView.findViewById(R.id.textv_age);
            }
        }
    }
        }

