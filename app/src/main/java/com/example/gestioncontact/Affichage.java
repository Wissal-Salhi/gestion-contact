package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity {

    private ArrayList<Contact> data = new ArrayList<Contact>();
    private ListView lv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        lv = findViewById(R.id.lv_aff);

        ContactManager manager = new ContactManager(Affichage.this);

        manager.ouvrir();

        data = manager.getAllContact();

        MonAdapter ad = new MonAdapter(Affichage.this, data);
        lv.setAdapter(ad);

    }
}