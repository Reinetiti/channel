package com.example.channel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<chaine> extends AppCompatActivity {
    RecyclerView recyclerView;
    List<chaine> chaines;
    private static String JSON_URL ="https://run.mocky.io/v3/9ab3169a-be4f-4ab2-aa75-96add52249a5";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.channelList);
        chaines = new ArrayList<>();
        extractChaines();
    }

    private void extractChaines() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject chaineObject = response.getJSONObject(i);

                        Chaine chaine = new Chaine();
                        chaine.setTitle(chaineObject.getString("chaine").toString());
                        chaine.setChaine(chaineObject.getString("chaine".toString()));
                        chaine.setCoverImage(chaineObject.getString("cover_image"));
                        chaine.setImageURL(chaineObject.getString("url"));
                        chaines.add((chaine) chaine);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                List<Chaine> songs;
                adapter = new Adapter(getApplicationContext(), (List<Chaine>) chaines);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
        }
    }
