package com.example.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class OverviewFragment extends Fragment {

    private List<Todo> list;
    private RecyclerView recyclerView;
    public OverviewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_overview, container, false);
        recyclerView = view.findViewById(R.id.rvTodos);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        list = new ArrayList<>();
        list.add(new Todo("Boodschappen", "Eieren, melk, brood"));
        list.add(new Todo("Was", "Witte was"));
        recyclerView.setAdapter(new TodoAdapter(list));
        return view;
    }
}
