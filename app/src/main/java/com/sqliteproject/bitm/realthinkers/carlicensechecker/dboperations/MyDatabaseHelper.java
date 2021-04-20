package com.sqliteproject.bitm.realthinkers.carlicensechecker.dboperations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CarInfo";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "CarInfoHolder";

    public static final String COLUMN_INDEX = "ID";
    public static final String MODEL_NUMBER = "ModelNo";
    public static final String CHASSIS_NUMBER = "ChassisNo";
    public static final String OWNER = "Owner";
    public static final String LICENSE_NUMBER = "LicenseNo";
    public static final String EXPIRY_DATE = "ExpDate";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_INDEX + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + MODEL_NUMBER + " TEXT, " + CHASSIS_NUMBER + " Text, " + OWNER + " TEXT, " + LICENSE_NUMBER + " TEXT, " + EXPIRY_DATE + " DATE);";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
