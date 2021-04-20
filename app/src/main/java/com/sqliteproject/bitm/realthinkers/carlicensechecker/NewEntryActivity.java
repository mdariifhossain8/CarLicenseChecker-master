package com.sqliteproject.bitm.realthinkers.carlicensechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sqliteproject.bitm.realthinkers.carlicensechecker.dboperations.CarDatabaseManager;
import com.sqliteproject.bitm.realthinkers.carlicensechecker.models.Car;

public class NewEntryActivity extends AppCompatActivity {
    EditText etModelNo, etChassisNo,etOwner,etLicenseNo,etExpDate;
    Button entryBtn;
    CarDatabaseManager carDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        etModelNo = findViewById(R.id.etModelNo);
        etChassisNo = findViewById(R.id.etChassisNo);
        etOwner = findViewById(R.id.etOwner);
        etLicenseNo = findViewById(R.id.etLicenseNo);
        etExpDate = findViewById(R.id.etExpDate);

        carDatabaseManager = new CarDatabaseManager(this);

    }

    public void enterNew(View view) {
        Car car = new Car(etModelNo.getText().toString(),etChassisNo.getText().toString(),etOwner.getText().toString(),
                etLicenseNo.getText().toString(),etExpDate.getText().toString());
        long insertedRow = carDatabaseManager.adCar(car);
        if (insertedRow>0){
            Toast.makeText(this, ""+insertedRow, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "something wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
