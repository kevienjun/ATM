package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    List<String> fruits = Arrays.asList("香蕉","鳳梨","芭樂");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,Login.class);
            //startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }
        //data
        ArrayList();
    }

    private void ArrayList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_expandable_list_item_1, fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK ){
                finish();
            }else{
                //TODO: if nickname / age /gender exist
                String saveNickname = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("USERNICKNAME", null);
                int saveAge = getSharedPreferences("user",MODE_PRIVATE)
                        .getInt("USERAGE", 0);
                int saveGender = getSharedPreferences("user",MODE_PRIVATE)
                        .getInt("USERGENDER", 0);

                if (saveNickname == null || saveAge == 0 || saveGender == 0) {
                    Intent nickname = new Intent(this,NicknameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }
}