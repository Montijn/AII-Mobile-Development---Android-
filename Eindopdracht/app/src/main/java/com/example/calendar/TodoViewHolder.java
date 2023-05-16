package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class TodoViewHolder extends RecyclerView.ViewHolder
{
    TextView _description;
    TextView _details;
    TodoViewHolder(View view)
    {
        super(view);
        this._description = view.findViewById(R.id.description);
        this._details = view.findViewById(R.id.details);
    }

}
