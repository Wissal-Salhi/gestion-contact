package com.example.gestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProduitHelper extends SQLiteOpenHelper {

    public static final String table_produit = "Produits";
    public static final String col_id = "ID";
    public static final String col_intitule = "Intitule";
    public static final String col_designation = "Designation";
    public static final String col_prix = "Prix";
    public static final String col_quantite = "Quantite";

    String requeute = "create table "+ table_produit + " (" +  col_id + " Integer Primary Key Autoincrement, " +
            col_intitule + " Text not null, " + col_designation + " Text not null, " +
            col_prix + " Real, " + col_quantite + " Integer)";


    public ProduitHelper(@Nullable Context context, @Nullable String name,
                         @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Lors de l'ouverture de la base
        db.execSQL(requeute);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //En cas de modification de la version
        db.execSQL("drop table "+table_produit);
        onCreate(db);
    }
}
