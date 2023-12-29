package com.example.taktau;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager salesman;
    ListView lv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listview);

        salesman = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = salesman.getSensorList(Sensor.TYPE_ALL);

        lv.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, sensorList));
    }
}