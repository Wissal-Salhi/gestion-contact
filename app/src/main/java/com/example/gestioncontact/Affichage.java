package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity {

    private ArrayList<Produit> data = new ArrayList<Produit>();

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        lv = findViewById(R.id.lv_aff);

        ProduitManager manager = new ProduitManager(Affichage.this);

        manager.ouvrir();
        manager.ajout("test produit 1","test designation 1",12.5,50);
        manager.ajout("test produit 2","test designation 2",22.5,0);
        manager.ajout("test produit 3","test designation 3",13.5,30);
        manager.ajout("test produit 4","test designation 4",12.4,40);
        manager.ajout("test produit 5","test designation 5",52.5,50);

        data = manager.getAllProduit();

        MonAdapter ad = new MonAdapter(Affichage.this, data);
        lv.setAdapter(ad);
    }
}