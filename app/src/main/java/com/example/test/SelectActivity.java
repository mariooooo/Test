package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);
    }

    public void OnActionButtonClick(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        switch (v.getId()) {
            case R.id.game1: {
                intent.putExtra("w", 3);
                intent.putExtra("h", 1);
                intent.putExtra("title", "Game 1");
                break;
            }
            case R.id.game2: {
                intent.putExtra("w", 4);
                intent.putExtra("h", 2);
                intent.putExtra("title", "Game 2");
                break;
            }
            case R.id.game3: {
                intent.putExtra("w", 5);
                intent.putExtra("h", 2);
                intent.putExtra("title", "Game 3");
                break;
            }
            case R.id.game4: {
                intent.putExtra("w", 4);
                intent.putExtra("h", 20);
                intent.putExtra("title", "Game 4");
                break;
            }
            case R.id.game5: {
                intent.putExtra("w", 3);
                intent.putExtra("h", 20);
                intent.putExtra("title", "Game 5");
                break;
            }
        }
        startActivity(intent);
    }
}
