package com.example.gestioncontact;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {

    private ArrayList<Produit> data;
    private Context con;

    public MonAdapter( Context con, ArrayList<Produit> data) {
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
        TextView tvintitul = card.findViewById(R.id.tvintitul_aff);
        TextView tvdesign = card.findViewById(R.id.tvdesign_aff);
        TextView tvprix = card.findViewById(R.id.tvprix_aff);
        TextView tvquantite = card.findViewById(R.id.tvquantite_aff);

        //Affecter les valeurs des champs
        Produit p = data.get(i);
        tvid.setText(""+p.getId());
        tvintitul.setText(p.getIntitule());
        tvdesign.setText(p.getDesignation());
        tvprix.setText(""+p.getPrix());
        tvquantite.setText(""+p.getQuantite());

        if (p.getQuantite() == 0){
            tvquantite.setText("Sold out");
            tvquantite.setTextColor(Color.RED);
        }

        return card;
    }
}
