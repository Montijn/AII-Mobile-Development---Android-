package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    private List<Todo> list;
    private JSONObject todo;
    private Todo test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        jsonParse();
    }
    private void jsonParse(){
        String key = "5e6ce87ff9744e4cba89e579799aad58";
        String url = "https://dummyjson.com/products?limit=2";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>()
            {
                @Override public void onResponse(JSONObject response)
                {
                    try {
                        JSONArray jsonArray = response.getJSONArray("products");
                        for(int i = 0; i < jsonArray.length(); i++){
                            todo = jsonArray.getJSONObject(i);
                            test = new Todo(todo.getString("title"), todo.getString("description"));
                            list.add(test);
                        }
                    } catch (JSONException e) {

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


}
