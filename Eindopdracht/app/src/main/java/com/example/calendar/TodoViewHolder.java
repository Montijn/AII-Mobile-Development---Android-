package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class TodoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private TodoAdapter.RecyclerViewClickListener _listener;
    private TextView _description;
//    private TextView _details;
    public TodoViewHolder(View view)
    {
        super(view);
        _description = view.findViewById(R.id.description);
//        _details = view.findViewById(R.id.details);
        view.setOnClickListener(this);
    }
    public TextView getDescription(){
        return _description;
    }
//    public TextView getDetails(){
//        return _details;
//    }

    @Override
    public void onClick(View view) {
        _listener.onClick(view,getAdapterPosition());
    }
}
