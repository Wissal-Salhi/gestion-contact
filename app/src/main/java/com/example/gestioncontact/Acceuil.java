package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Acceuil extends AppCompatActivity {

    private TextView tvusername;
    private Button btnajout, btnaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        
        tvusername = findViewById(R.id.tvuser_acc);
        btnajout = findViewById(R.id.btnajout_acc);
        btnaff = findViewById(R.id.btnaff_acc);

        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String u = b.getString("username");

        tvusername.setText("Acceuil de Mr."+u);

    }
}