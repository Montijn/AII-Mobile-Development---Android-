package com.example.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder>
{
    private List<Todo> dataset;

    public TodoAdapter(List<Todo> todos){
        this.dataset = todos;
    }
    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position)
    {
        holder._description.setText(dataset.get(position)._description);
        holder._details.setText(dataset.get(position)._details);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

}
