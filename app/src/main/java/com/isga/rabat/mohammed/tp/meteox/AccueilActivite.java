package com.isga.rabat.mohammed.tp.meteox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.isga.rabat.mohammed.tp.meteox.metier.HandleJson;

public class AccueilActivite extends AppCompatActivity {
    private String url1="https://api.openweathermap.org/data/2.5/weather?q=";
    private TextView pays,temp,hum,pres,etat;
    private ImageButton ok,vent_btn,coucher_lever_btn;
    private EditText loc;
    private HandleJson obj;
    String urlcomp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_activite);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        temp=findViewById(R.id.degree_temperature);
        pres=findViewById(R.id.qte_pression);
        etat=findViewById(R.id.etat_meteo);
        pays=findViewById(R.id.txt_pays);
        hum=findViewById(R.id.txt_humidite);
        loc=(EditText) findViewById(R.id.localisation);
        ok=findViewById(R.id.btn_ok);
        vent_btn=findViewById(R.id.vent_btn);
        coucher_lever_btn=findViewById(R.id.btn_coucher_lever);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=loc.getText().toString();
                urlcomp=url1+s+"&lang=fr&APPID=d3b17832a978953a9a1eed38b7e8562d";
                obj=new HandleJson(urlcomp);
                obj.fetchJSON();
                    while (obj.finPersing){
                        pays.setText(obj.getPays());
                        temp.setText(String.format("%.1f",obj.getTemperature())+"°C");
                        hum.setText(obj.getHumidite()+"%");
                        pres.setText(obj.getPression()+ " Pa");
                        etat.setText(obj.getEtat());
                    }

                    
                }

        });

        vent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vent_intent= new Intent(getApplicationContext(),vent_activite.class);
                startActivity(vent_intent);
            }
        });

        coucher_lever_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coucher_lever_intent= new Intent(getApplicationContext(),lever_coucher_soleil_activite.class);
                startActivity(coucher_lever_intent);
            }
        });
    }
}