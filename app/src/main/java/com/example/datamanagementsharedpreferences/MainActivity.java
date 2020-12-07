package com.example.datamanagementsharedpreferences;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        score = sp.getInt("h_score",0);
        EditText et_h = findViewById(R.id.hs_et);
        et_h.setText(String.valueOf(score));
    }

    public void score_bt(View v){
        EditText et = findViewById(R.id.gs_et);
        EditText et_h = findViewById(R.id.hs_et);
        Random r = new Random();
        score = r.nextInt(1000);
        et.setText(String.valueOf(score));
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        if(score > sp.getInt("h_score",0)){
            // Get and edit high score
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("h_score", score);
            editor.commit();

            et_h.setText(String.valueOf(score));
        }
    }

    public void reset_bt(View v){
        EditText et = findViewById(R.id.gs_et);
        EditText et_h = findViewById(R.id.hs_et);
        score = 0;
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("h_score", score);
        editor.commit();
        et.setText(String.valueOf(score));
        et_h.setText(String.valueOf(score));
    }
}
