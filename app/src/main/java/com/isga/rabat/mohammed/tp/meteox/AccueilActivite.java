package com.isga.rabat.mohammed.tp.meteox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.isga.rabat.mohammed.tp.meteox.metier.HandleJson;

public class AccueilActivite extends AppCompatActivity {
    private String url1="https://api.openweathermap.org/data/2.5/weather?q=";
    private TextView pays,temp,hum,pres,etat;
    private Button ok;
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
        loc=(EditText) findViewById(R.id.localisation);
        ok=findViewById(R.id.btn_ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=loc.getText().toString();
                urlcomp=url1+s+"&lang=fr&APPID=d3b17832a978953a9a1eed38b7e8562d";
                obj=new HandleJson(urlcomp);
                obj.fetchJSON();
                    while (obj.finPersing){
                        //pays.setText(obj.getPays());
                        //Double temp_celicius=Double.parseDouble(obj.getTemperature());
                        temp.setText(String.format("%.1f",obj.getTemperature())+"°C");
                        //hum.setText(obj.getHumidite());
                        pres.setText(obj.getPression()+ " Pa");
                        etat.setText(obj.getEtat());
                    }

                    
                }

        });
    }
}