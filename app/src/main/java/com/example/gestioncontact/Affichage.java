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
        data.add(new Produit(1,"test produit 1","test designation 1",12.5,50));
        data.add(new Produit(2,"test produit 2","test designation 2",22.5,50));
        data.add(new Produit(3,"test produit 3","test designation 3",13.5,30));
        data.add(new Produit(4,"test produit 4","test designation 4",12.4,40));

        ArrayAdapter ad = new ArrayAdapter(Affichage.this,
                android.R.layout.simple_list_item_1, data);
        lv.setAdapter(ad);
    }
}