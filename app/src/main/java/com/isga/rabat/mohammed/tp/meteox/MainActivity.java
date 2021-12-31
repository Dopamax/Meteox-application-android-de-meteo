package com.isga.rabat.mohammed.tp.meteox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button entrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        entrer=findViewById(R.id.btn_entrer);

        entrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccueilActivite.class);
                startActivity(i);

            }
        });
    }
}