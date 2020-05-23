package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    public void generateTable(int tableNumber){
        ArrayList<String> tableContemt = new ArrayList<String>();
        for(int i = 1; i <= 10; i++){
            tableContemt.add(Integer.toString(i*tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContemt);
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar mySeekBar = findViewById(R.id.mySeekBar);
        myListView = findViewById(R.id.myListView);

        int initialProgress = 10;

        mySeekBar.setMax(20);
        mySeekBar.setProgress(initialProgress);
        generateTable(initialProgress);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int tableNum;
                if(progress < min){
                    tableNum = min;
                    mySeekBar.setProgress(min);
                }else{
                    tableNum = progress;
                }

                generateTable(tableNum);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
