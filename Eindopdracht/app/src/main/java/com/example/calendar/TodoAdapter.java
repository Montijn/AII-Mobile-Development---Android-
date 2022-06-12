package com.example.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder>
{
    private List<Todo> dataset;
    private RecyclerViewClickListener listener;

    public TodoAdapter(List<Todo> todos, RecyclerViewClickListener listener){
        this.dataset = todos;
        this.listener = listener;
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
        holder.getDescription().setText(dataset.get(position).getDescription());
//        holder.getDetails().setText(dataset.get(position).getDetails());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetailFragment detailFragment = new DetailFragment();
                String test = dataset.get(holder.getAdapterPosition()).getDetails().toString();
                detailFragment.setArguments(new Bundle());
                detailFragment.getArguments().putString("detail", test);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.overviewFragment, detailFragment)
                    .addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position );

    }
}
