package com.example.blood_donor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DB12345";
    private static final int DATABASE_VER = 1;

    public DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE donor(eid INTEGER, fn TEXT, ln TEXT, bg TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS donor");
        onCreate(sqLiteDatabase);
    }

    // INSERT
    public void getDataHelper(int id1, String fname1, String lname1, String bgroup1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("eid", id1);
        values.put("fn", fname1);
        values.put("ln", lname1);
        values.put("bg", bgroup1);

        db.insert("donor", null, values);
        db.close();
    }

    // FETCH
    public String fetchDataHelper() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"eid", "fn", "ln", "bg"};

        Cursor cursor = db.query(
                "donor",
                columns,
                null,
                null,
                null,
                null,
                null
        );

        StringBuilder buffer = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                String eid = cursor.getString(cursor.getColumnIndexOrThrow("eid"));
                String fname = cursor.getString(cursor.getColumnIndexOrThrow("fn"));
                String lname = cursor.getString(cursor.getColumnIndexOrThrow("ln"));
                String bg = cursor.getString(cursor.getColumnIndexOrThrow("bg"));

                buffer.append(eid).append(" ").append(fname).append(" ").append(lname).append(" ").append(bg).append("\n");
            } while (cursor.moveToNext());
        }

        cursor.close();
        return buffer.toString();
    }}
