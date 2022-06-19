package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class OverviewFragment extends Fragment {
    private List<Product> list;
    private JSONObject jsonTodo;
    private Product product;
    private RequestQueue queue;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ProductAdapter.RecyclerViewClickListener listener;
    public OverviewFragment() {

    }
    interface onClickListener{
        void onItemSelected(String detail);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_overview, container, false);
        queue = Volley.newRequestQueue(this.getContext());
        recyclerView = view.findViewById(R.id.rvTodos);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        list = new ArrayList<Product>();
        setTodos();
        return view;
    }
    private void setTodos(){
        String key = "5e6ce87ff9744e4cba89e579799aad58";
        String url = "https://dummyjson.com/products?limit=10";
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>()
            {
                @Override public void onResponse(JSONObject response)
                {
                    try {
                        JSONArray jsonArray = response.getJSONArray("products");
                        for(int i = 0; i < jsonArray.length(); i++){
                            jsonTodo = jsonArray.getJSONObject(i);
                            product = new Product(jsonTodo.getString("title"), jsonTodo.getString("description"));
                            list.add(product);
                        }
                        adapter = new ProductAdapter(list, listener);
                        recyclerView.setAdapter(adapter);
                        setOnClickListener();
                    }
                    catch (JSONException e) {

                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener()
            {
                @Override public void onErrorResponse(VolleyError error)
                {
                    error.printStackTrace();
                }
            });
        queue.add(jsonObjectRequest);
    }


    private void setOnClickListener() {
        listener = new ProductAdapter.RecyclerViewClickListener(){

            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), OverviewFragment.class);
                intent.putExtra("details", list.get(position).getDetails());
                startActivity(intent);
            }
        };
    }

}
