package com.androcid.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdpter extends RecyclerView.Adapter<TaskAdpter.TaskViewHolder>{
    Context context;
    List<Task> list;
    public TaskAdpter(Context context, List<Task> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.task_view,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.task.setText(list.get(position).getTask_title());
        holder.description.setText(list.get(position).getTask_description());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        TextView task,description;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.task);
            description = itemView.findViewById(R.id.desc);

        }

    }
}
