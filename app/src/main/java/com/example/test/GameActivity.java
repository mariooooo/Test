package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    GridView grid;
    GameAdapter gameAdapter;
    List<Integer> availableColors;
    List<Integer> colors = new ArrayList<>();
    int count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        TextView title = findViewById(R.id.title);
        title.setText(getIntent().getStringExtra("title"));

        count = getIntent().getIntExtra("w", 0) * getIntent().getIntExtra("h",0);
        grid = (GridView) findViewById(R.id.grid);
        grid.setNumColumns(getIntent().getIntExtra("w", 1));

        availableColors = new ArrayList<>(Arrays.asList(
                this.getResources().getColor(R.color.red),
                this.getResources().getColor(R.color.orange),
                this.getResources().getColor(R.color.yellow),
                this.getResources().getColor(R.color.green),
                this.getResources().getColor(R.color.blue),
                this.getResources().getColor(R.color.indigo),
                this.getResources().getColor(R.color.violet),
                this.getResources().getColor(R.color.white),
                this.getResources().getColor(R.color.stf),
                this.getResources().getColor(R.color.colorPrimary),
                this.getResources().getColor(R.color.colorAccent)
        ));
        for(int i=0;i<count;i++){
            colors.add(getRandomColor());
        }
        gameAdapter = new GameAdapter(this, count, colors);
        grid.setAdapter(gameAdapter);
    }

    public void OnActionButtonClick(View v) {
        switch (v.getId()) {
            case R.id.shuffle: {
                Collections.shuffle(colors);
                gameAdapter.notifyDataSetChanged();
                grid.setAdapter(gameAdapter);
                break;
            }
            case R.id.back: {
                finish();
                break;
            }
        }
    }

    public int getRandomColor(){
        Random rand = new Random();
        return availableColors.get(rand.nextInt(availableColors.size()));
    }

}
