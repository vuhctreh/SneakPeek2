package com.victor.sneakpeek2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Collection database.
 */
public class CollectionDatabase extends android.database.sqlite.SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "collectionDB";
    private static final String DATABASE_TABLE = "collectionTable";

    // column names for DB table. ID is the primary key and auto increments.
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SKU = "sku";

    /**
     * Instantiates a new Collection database.
     *
     * @param context the context
     */
    CollectionDatabase(Context context) {
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
        // discards previous and creates new database upon version changes
        if (oldVersion >= newVersion) return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    /**
     * Adds shoe to SQL database.
     *
     * @param shoe the shoe
     * @return the long returned by the SQL query
     */
    public long addShoe(Shoe shoe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shoe.getName());
        values.put(KEY_SKU, shoe.getSku());

        return db.insert(DATABASE_TABLE, null, values);
    }

    /**
     * Gets shoe from database.
     *
     * @param id the id
     * @return the shoe
     */
    public Shoe getShoe(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE, new String[]{KEY_ID, KEY_NAME, KEY_SKU}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null) cursor.moveToFirst();

        return new Shoe(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    /**
     * Gets all shoes in database.
     *
     * @return a list of shoes "allShoes"
     */
    public List<Shoe> getShoes() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Shoe> allShoes = new ArrayList<>();

        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Shoe shoe = new Shoe();
                shoe.setID(cursor.getLong(0));
                shoe.setName(cursor.getString(1));
                shoe.setSku(cursor.getString(2));

                allShoes.add(shoe);
            } while (cursor.moveToNext());
        }
        return allShoes;
    }

    /**
     * Delete shoe from database
     *
     * @param id the id of the shoe to be deleted
     */
    public void deleteShoe(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, KEY_ID + "=?", new String[] {String.valueOf(id)});
        db.close();
    }

    /**
     * Updates specific shoe in database.
     *
     * @param shoe the shoe
     * @return the int returned by the database query.
     */
    public int editShoe (Shoe shoe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shoe.getName());
        values.put(KEY_SKU, shoe.getSku());
        return db.update(DATABASE_TABLE, values, KEY_ID + "=?", new String[] {String.valueOf(shoe.getID())});
    }

}
