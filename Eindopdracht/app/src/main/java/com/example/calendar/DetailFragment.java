package com.example.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {


    public DetailFragment() {

    }
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = view.findViewById(R.id.detail);
        if(getArguments() !=null ){
            String detail = getArguments().getString("detail");
            setDetail(detail);
        }
        return view;
    }

    public void setDetail(String detail){
        textView.setText(detail);

    }
}
