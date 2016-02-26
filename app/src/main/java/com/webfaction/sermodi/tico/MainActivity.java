package com.webfaction.sermodi.tico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private RequestQueue queue;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.texto);
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.button);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String url ="http://tico.sermodi.webfactional.com/rest-auth/login/";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        text.setText("Hola " + "Nacho");
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                text.setText("Cargando...");
            }
        }
        ){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "Nacho");
                params.put("password", "nacho");

                return params;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RutinaActivity.class);
                startActivity(intent);
            }
        });
    }
}
