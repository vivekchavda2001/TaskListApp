package com.androcid.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class mHomeScreen extends AppCompatActivity {
    TextView task_count,task,desc,tsk_title;
    myDatabase database;
    List<Task> list;
    CardView task_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        getSupportActionBar().setTitle("Task App");
        task_view = findViewById(R.id.task_view);
        tsk_title = findViewById(R.id.task_msg);
        task_count = findViewById(R.id.task_count);
        task = findViewById(R.id.task);
        desc = findViewById(R.id.desc);
        setDB();
        list = database.dao().getTask();
        int count = database.dao().getCount();
        if(count > 0) {
            task.setText(list.get(0).getTask_title());
            desc.setText(list.get(0).getTask_description());
        }else {
            tsk_title.setText("No Recent Task");
            task_view.setVisibility(View.GONE);
        }
        task_count.setText("Task Count "+String.valueOf(count));
    }

    public void addTask(View view) {
        Intent i = new Intent(mHomeScreen.this,mAddTask.class);
        startActivity(i);
    }

    public void listTask(View view) {
        Intent i = new Intent(mHomeScreen.this,mListTask.class);
        startActivity(i);
    }
    public void setDB() {
        database = Room.databaseBuilder(mHomeScreen.this, myDatabase.class, "TaskDB")
                .allowMainThreadQueries().build();
    }
}