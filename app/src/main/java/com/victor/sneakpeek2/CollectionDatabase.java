package com.victor.sneakpeek2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CollectionDatabase extends android.database.sqlite.SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "collectionDB";
    private static final String DATABASE_TABLE = "collectionTable";

    // column names for DB table
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SKU = "sku";

    CollectionDatabase (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create database
        String query = "CREATE TABLE collectionTable(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, sku TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion) return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long addShoe(Shoe shoe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shoe.getName());
        values.put(KEY_SKU, shoe.getSku());

        return db.insert(DATABASE_TABLE, null, values);
    }

    public Shoe getShoe(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE, new String[]{KEY_ID, KEY_NAME, KEY_SKU}, KEY_ID+"=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if(cursor != null) cursor.moveToFirst();

        return new Shoe(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public List<Shoe> getShoes() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Shoe> allShoes = new ArrayList<>();

        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Shoe shoe = new Shoe();
                shoe.setID(cursor.getLong(0));
                shoe.setName(cursor.getString(1));
                shoe.setSku(cursor.getString(2));

                allShoes.add(shoe);
            } while(cursor.moveToNext());
        }
        return allShoes;
    }

}
