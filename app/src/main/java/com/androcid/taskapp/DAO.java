package com.androcid.taskapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {
    @Insert
    public abstract void taskinsertion(Task task);
    @Query("select * from Task order by taskid desc")
    List<Task> getTask();
    @Query("select count(taskid) from Task")
    int getCount();
}
