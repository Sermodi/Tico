package com.webfaction.sermodi.tico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RutinaActivity extends AppCompatActivity {

    TextView anterior, siguiente, actual;
    Button botonSi, botonNo;
    ImageView accion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
