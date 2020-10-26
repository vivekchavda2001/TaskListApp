package com.androcid.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class mListTask extends AppCompatActivity {
    RecyclerView recyclerView;
    myDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);
        getSupportActionBar().setTitle("List Of Tasks");
        recyclerView = findViewById(R.id.tasklist);
        setDB();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        List<Task> list =  myDatabase.dao().getTask();
        recyclerView.setAdapter(new TaskAdpter(this,list));
    }
    public void setDB() {
        myDatabase = Room.databaseBuilder(mListTask.this, myDatabase.class, "TaskDB")
                .allowMainThreadQueries().build();
    }

}