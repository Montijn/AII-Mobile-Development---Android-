package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class TodoViewHolder extends RecyclerView.ViewHolder
{
    TextView textView;
    TodoViewHolder(View view)
    {
        super(view);
        textView = view.findViewById(R.id.textView);
    }

}
