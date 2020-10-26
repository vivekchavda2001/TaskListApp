package com.androcid.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class mAddTask extends AppCompatActivity {
    myDatabase database;
    EditText title,description;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_add_task);
        getSupportActionBar().setTitle("Add Task");
        title = findViewById(R.id.task_title);
        description = findViewById(R.id.task_description);
        setDB();

    }

    public void setDB() {
        database = Room.databaseBuilder(mAddTask.this, myDatabase.class, "TaskDB")
                .allowMainThreadQueries().build();
    }


    public void addTask(View view) {
        Task task = new Task(title.getText().toString(),description.getText().toString());
        myDatabase myDatabase = Room.databaseBuilder(mAddTask.this,myDatabase.class,"TaskDB")
                .allowMainThreadQueries().build();
        database.dao().taskinsertion(task);
        Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
        overridePendingTransition(0, 0);
        Intent i = new Intent(mAddTask.this,mHomeScreen.class);
        startActivity(i);
    }
}
