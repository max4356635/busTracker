package com.bustrack.bustracker.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Administrator on 2017/04/09 0009.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAMES = "sqlitedata";
    private static final int DATABASE_VERSION = 3;

    public Database(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }
}
