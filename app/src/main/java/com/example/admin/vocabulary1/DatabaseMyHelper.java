package com.example.admin.vocabulary1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 06.04.2017.
 */

public class DatabaseMyHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Vocabulary";
    public static final String TABLE_VOCABULARY  = "vocabulary";

    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_TRANSLATE = "translate";

    public DatabaseMyHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_VOCABULARY + " ("+ KEY_ID +
        " integer primary key, " + KEY_WORD + " text, " + KEY_TRANSLATE +
        " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_VOCABULARY);
        onCreate(db);
    }
}
