package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ArticlesDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NewsApp.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ArticlesContract.ArticlesEntry.TABLE_NAME + " (" +
                    ArticlesContract.ArticlesEntry._ID + " INTEGER PRIMARY KEY," +
                    ArticlesContract.ArticlesEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ArticlesContract.ArticlesEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                    ArticlesContract.ArticlesEntry.COLUMN_NAME_DATE + " DATE," +
                    ArticlesContract.ArticlesEntry.COLUMN_NAME_LINK + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ArticlesContract.ArticlesEntry.TABLE_NAME;

    public ArticlesDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}