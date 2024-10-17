package com.example.blood_donor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DB123";
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

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
}
