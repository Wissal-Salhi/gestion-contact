package com.example.gestioncontact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {

    private ArrayList<Contact> data;
    private Context con;

    public MonAdapter( Context con, ArrayList<Contact> data) {
        this.data = data;
        this.con = con;
    }

    @Override
    public int getCount() { //retourne le nbr de view
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CardView card = null;

        //Creation d'un view
        LayoutInflater inf = LayoutInflater.from(con);
        card = (CardView) inf.inflate(R.layout.element, null);

        //Recuperation des champs
        TextView tvid = card.findViewById(R.id.tvid_aff);
        TextView tvnom_prenom = card.findViewById(R.id.tvnom_prenom_aff);
        TextView tvemail = card.findViewById(R.id.tvemail_aff);
        TextView tvnumero = card.findViewById(R.id.tvnum_aff);

        //Affecter les valeurs des champs
        Contact c = data.get(i);
        tvid.setText(""+c.getId());
        tvnom_prenom.setText(c.getNom()+" "+c.getPrenom());
        tvemail.setText(c.getEmail());
        tvnumero.setText(c.getNumero());

        if (c.getEmail().equals("")){
            tvemail.setText("Have no email");
        }

        return card;
    }

    public void removeItem(int i, View view) {
        CardView card = null;

        //Creation d'un view
        LayoutInflater inf = LayoutInflater.from(con);
        card = (CardView) inf.inflate(R.layout.element, null);

        //Recuperation des champs
        Button btnsupp = card.findViewById(R.id.btnsup_aff);
        TextView tvid = card.findViewById(R.id.tvid_aff);

        btnsupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactManager manager = new ContactManager(con);
                manager.ouvrir();
                manager.supprimerItem(tvid.getText().toString());
                Intent i = new Intent(con, Affichage.class);
                con.startActivity(i);
            }
        });

    }


}
