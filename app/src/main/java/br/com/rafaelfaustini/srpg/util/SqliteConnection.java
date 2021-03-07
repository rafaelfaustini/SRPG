package br.com.rafaelfaustini.srpg.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteConnection extends SQLiteOpenHelper {

    private static final String name = "database.db";
    private static final int version = 1;

    public SqliteConnection(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CAMPAIGN (ID INTEGER PRIMARY KEY, NAME TEXT, STORY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
