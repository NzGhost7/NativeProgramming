package com.example.task3lab7

import android.content.Context
import android.hardware.*
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var accelerometer: Sensor
    private lateinit var gyroscope: Sensor
    private lateinit var magnetometer: Sensor

    private lateinit var accelerometerText: TextView
    private lateinit var gyroscopeText: TextView
    private lateinit var magnetometerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accelerometerText = findViewById(R.id.accelerometerText)
        gyroscopeText = findViewById(R.id.gyroscopeText)
        magnetometerText = findViewById(R.id.magnetometerText)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        registerSensorListeners()
    }

    private fun registerSensorListeners() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> updateSensorText(accelerometerText, event.values)
            Sensor.TYPE_GYROSCOPE -> updateSensorText(gyroscopeText, event.values)
            Sensor.TYPE_MAGNETIC_FIELD -> updateSensorText(magnetometerText, event.values)
        }
    }

    private fun updateSensorText(textView: TextView, values: FloatArray) {
        val text = "X=${values[0]}, Y=${values[1]}, Z=${values[2]}"
        runOnUiThread { textView.text = text }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do something if accuracy changes
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorManager.unregisterListener(this)
    }
}
