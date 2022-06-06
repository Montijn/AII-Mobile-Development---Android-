package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        URL url = null;
        try {
            url = new URL("https://dummyjson.com/products?limit=2");
            new AsyncGetProduct().execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        jsonParse();
    }

    private class AsyncGetProduct extends AsyncTask<URL,Integer, String> {

        @Override
        protected String doInBackground(URL... urls) {
            final URL url = urls[0];

            final StringBuilder builder = new StringBuilder();

            for(int i = 0; i < 10; i++){
                builder.append(getProduct(url)).append("\n");
                publishProgress(10 * i);
            }
            return builder.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textview = findViewById(R.id.textView);
            textview.setText(result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setProgress(values[0]);
        }
    }
    String getProduct (URL url){

        StringBuilder result = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(1000);
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream  stream = connection.getInputStream();
                int character;
                while((character = stream.read()) != -1){
                    result.append((char) character);
                }
                stream.close();
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
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
