package com.example.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProduitManager {

    SQLiteDatabase db = null;
    Context context;

    ProduitManager(Context context){
        this.context = context;
    }

    public void ouvrir(){
        ProduitHelper helper = new ProduitHelper(context,"mabase.db",null, 1);
        db = helper.getWritableDatabase();
    }

    public long ajout(String intitule, String desig, double prix, int qte){
        long res = 0;
        ContentValues values = new ContentValues();

        values.put(ProduitHelper.col_intitule, intitule);
        values.put(ProduitHelper.col_designation,desig);
        values.put(ProduitHelper.col_prix,prix);
        values.put(ProduitHelper.col_quantite,qte);

        res = db.insert(ProduitHelper.table_produit, null, values);
        return res;
    }

    public ArrayList<Produit> getAllProduit(){
        ArrayList<Produit> produits = new ArrayList<Produit>();

        Cursor cr = db.query(ProduitHelper.table_produit,
                        new String[]{ProduitHelper.col_id,
                                ProduitHelper.col_intitule,
                                ProduitHelper.col_designation,
                                ProduitHelper.col_prix,
                                ProduitHelper.col_quantite},
                            null, null,
                            null,null,null);

        cr.moveToFirst();
        while (!cr.isAfterLast()){
            int i1 = cr.getInt(0);
            String i2 = cr.getString(1);
            String i3 = cr.getString(2);
            double i4 = cr.getDouble(3);
            int i5 = cr.getInt(4);
            produits.add(new Produit(i1,i2,i3,i4,i5));
            cr.moveToNext();
        }




        return produits;
    }

    public void supprimer(){

    }

    public void fermer(){

    }
}
