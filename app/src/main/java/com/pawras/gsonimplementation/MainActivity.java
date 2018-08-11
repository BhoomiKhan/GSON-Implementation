package com.pawras.gsonimplementation;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotificationToAdmin();
    }

    private void sendNotificationToAdmin() {
        final ProgressDialog loading = ProgressDialog.show(MainActivity.this, "Placing order", "Please wait..", false, false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://tornadofoods.com/klicken/getAllOrders.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Log.d("response", response.toString());

                        GsonBuilder mGsonBuilder=new GsonBuilder();
                        Gson mGson=mGsonBuilder.create();
                        List<Post> posts = Arrays.asList(mGson.fromJson(response, Post[].class));
                        Toast.makeText(MainActivity.this, "size of list is "+posts.size(), Toast.LENGTH_SHORT).show();
                        for (Post post:posts) {
                            Toast.makeText(MainActivity.this, post.getPhone_number(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new Hashtable<String, String>();
                //Adding parameters
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}