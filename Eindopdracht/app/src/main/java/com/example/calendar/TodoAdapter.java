package com.example.calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder>
{
    private List<Todo> dataset;

    public TodoAdapter(List<Todo> todos){
        this.dataset = todos;
    }
    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position)
    {
        holder.GetDescription().setText(dataset.get(position)._description);
        holder.GetDetails().setText(dataset.get(position)._details);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

}
