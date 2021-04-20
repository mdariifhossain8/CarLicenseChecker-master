package com.sqliteproject.bitm.realthinkers.carlicensechecker.dboperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sqliteproject.bitm.realthinkers.carlicensechecker.models.Car;

import java.util.ArrayList;

public class CarDatabaseManager {

    private MyDatabaseHelper myDatabaseHelper;
    private Context context1;
    public CarDatabaseManager(Context context) {
        this.context1 = context;
        myDatabaseHelper= new MyDatabaseHelper(context);
    }

    public long adCar(Car car){

        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.MODEL_NUMBER,car.getModelNo());
        contentValues.put(MyDatabaseHelper.CHASSIS_NUMBER,car.getChassisNo());
        contentValues.put(MyDatabaseHelper.OWNER,car.getOwner());
        contentValues.put(MyDatabaseHelper.LICENSE_NUMBER,car.getLicenseNo());
        contentValues.put(MyDatabaseHelper.EXPIRY_DATE,car.getExpDate());
        long dataInserted = sqLiteDatabase.insert(MyDatabaseHelper.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        return dataInserted;
    }

    public long updateCarLicense(Car car){

        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.LICENSE_NUMBER,car.getLicenseNo());
        contentValues.put(MyDatabaseHelper.EXPIRY_DATE,car.getExpDate());
        long dataUpdated= sqLiteDatabase.update(MyDatabaseHelper.TABLE_NAME,contentValues,
                 MyDatabaseHelper.LICENSE_NUMBER+" = ? ",new String[]{String.valueOf(car.getLicenseNo())});
        sqLiteDatabase.close();
        return dataUpdated;
    }

    public long deleteCarLicense(Car car){
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        long dataDeleted = sqLiteDatabase.delete(MyDatabaseHelper.TABLE_NAME,
                MyDatabaseHelper.LICENSE_NUMBER+" =? "
                ,new String[]{String.valueOf(car.getLicenseNo())});
        return dataDeleted;
    }


    public ArrayList<Car>getAllCar() {
        ArrayList<Car>carArrayList= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        String selectQuery= "SELECT * FROM "+MyDatabaseHelper.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){

            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_INDEX));
                String model = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.MODEL_NUMBER));
                String chaNo = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.CHASSIS_NUMBER));
                String owner = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.OWNER));
                String liceNo = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.LICENSE_NUMBER));
                String expDate = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.EXPIRY_DATE));
                Car car = new Car(id,model,chaNo,owner,liceNo,expDate);
                carArrayList.add(car);

            } while (cursor.moveToNext());

        }

        return carArrayList;
    }




}
