package com.example.task1b

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var salesman: SensorManager
    private lateinit var lv: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.listview)

        salesman = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList: List<Sensor> = salesman.getSensorList(Sensor.TYPE_ALL)

        // Use 'this' as the context in the ArrayAdapter constructor
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sensorList)
    }
}
