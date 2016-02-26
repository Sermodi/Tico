package com.webfaction.sermodi.tico;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RutinaActivity extends AppCompatActivity {

    TextView anterior, siguiente, actual;
    Button botonSi, botonNo;
    ImageView accion;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);
        queue = Volley.newRequestQueue(this);
        actual = (TextView) findViewById(R.id.actual);
        accion = (ImageView) findViewById(R.id.img_tarea);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String url ="http://tico.sermodi.webfactional.com/actividades/1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        final Gson gson = new Gson();
                        //Trasformamos el Json en una especie de diccionario.
                        final Properties properties = gson.fromJson(response, Properties.class);

                        String strAccion = properties.getProperty("descripcion");

                        Context context = accion.getContext();
                        int id = context.getResources().getIdentifier(strAccion.toLowerCase(), "drawable", context.getPackageName());
                        accion.setImageResource(id);
                        actual.setText(properties.getProperty("descripcion"));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        actual.setText("Cargando...");
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

    }
}
