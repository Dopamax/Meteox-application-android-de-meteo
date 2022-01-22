package com.isga.rabat.mohammed.tp.meteox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.isga.rabat.mohammed.tp.meteox.metier.HandleJson;

public class vent_activite extends AppCompatActivity {
    TextView txt_vitesse,txt_degre;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vent_activite);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        txt_degre=findViewById(R.id.txt_degre);
        txt_vitesse=findViewById(R.id.txt_vitesse);
        txt_degre.setText(HandleJson.degre_vent+"°");
        txt_vitesse.setText(HandleJson.vitesse_vent+" KM/H");
        btn_back=findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}