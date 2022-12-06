package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaration des composantes
    private EditText ednom, edpass;
    private Button btnval, btnqte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperation du composantes
        ednom = findViewById(R.id.ednom_auth);
        edpass = findViewById(R.id.edpass_auth);

        btnval = findViewById(R.id.btnval_auth);
        btnqte = findViewById(R.id.btnqte_auth);

        //ecouteurs d'actions
        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // or just finish()
            }
        });

        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = ednom.getText().toString();
                String mp = edpass.getText().toString();
                if (nom.equalsIgnoreCase("wissal")&&mp.equals("0000")){
                    Intent i = new Intent(MainActivity.this, Acceuil.class);
                    i.putExtra("username",nom); //putExtra is a hashmap to transfer data between activities
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Valeur du nom ou mot de passe non valide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}