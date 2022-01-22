package com.isga.rabat.mohammed.tp.meteox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.isga.rabat.mohammed.tp.meteox.metier.HandleJson;

public class lever_coucher_soleil_activite extends AppCompatActivity {

    ImageButton btn_back;
    TextView lever_soleil,coucher_soleil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lever_coucher_soleil_activite);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        btn_back=findViewById(R.id.btn_back_for_soleil_act);
        lever_soleil=findViewById(R.id.txt_lever);
        coucher_soleil=findViewById(R.id.txt_coucher);
        coucher_soleil.setText(HandleJson.ConversionLeverCoucher(Double.parseDouble(HandleJson.coucher_soleil)));
        lever_soleil.setText(HandleJson.ConversionLeverCoucher(Double.parseDouble(HandleJson.lever_soleil)));
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}