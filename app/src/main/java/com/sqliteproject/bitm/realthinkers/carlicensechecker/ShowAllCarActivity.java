package com.sqliteproject.bitm.realthinkers.carlicensechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sqliteproject.bitm.realthinkers.carlicensechecker.dboperations.CarDatabaseManager;
import com.sqliteproject.bitm.realthinkers.carlicensechecker.models.Car;

import java.util.ArrayList;

public class ShowAllCarActivity extends AppCompatActivity {

    ListView listView;
    CarDatabaseManager carDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_car);

        listView = findViewById(R.id.carList);

        carDatabaseManager = new CarDatabaseManager(getApplicationContext());
        ArrayList<Car> carArrayLists=carDatabaseManager.getAllCar();
        ArrayList<String> list = new ArrayList<>();

        for (Car car:carArrayLists){
            list.add(car.getModelNo()+" "+car.getChassisNo()+" "+car.getOwner()+" "+car.getLicenseNo()+" "+car.getExpDate());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }
}
