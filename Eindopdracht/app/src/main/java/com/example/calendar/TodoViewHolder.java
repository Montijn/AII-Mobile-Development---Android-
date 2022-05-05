package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class TodoViewHolder extends RecyclerView.ViewHolder
{
    private TextView _description;
    private TextView _details;
    public TodoViewHolder(View view)
    {
        super(view);
        _description = view.findViewById(R.id.description);
        _details = view.findViewById(R.id.details);
    }
    public TextView GetDescription(){
        return _description;
    }
    public TextView GetDetails(){
        return _details;
    }

}
