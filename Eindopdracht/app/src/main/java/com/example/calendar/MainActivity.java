package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        RecyclerView recyclerView = findViewById(R.id.rvTodos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        jsonParse();
        recyclerView.setAdapter(new TodoAdapter(list));
    }
    private void jsonParse(){
        String url = "http://myjson.dit.upm.es/api/bins/ay9d";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            response -> {
                try {
                    JSONArray jsonArray = response.getJSONArray("todos");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject todo = jsonArray.getJSONObject(i);
                        list.add(new Todo(todo.getString("description")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, Throwable::printStackTrace);
        queue.add(request);
    }


}
