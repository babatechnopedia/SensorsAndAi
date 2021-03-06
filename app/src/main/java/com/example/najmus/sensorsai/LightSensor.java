package com.example.najmus.sensorsai;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LightSensor extends AppCompatActivity implements SensorEventListener {
    TextView textView;
    SensorManager sensorManager;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
        textView = (TextView) findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService( Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType( ) == Sensor.TYPE_LIGHT){
            textView.setText(""+ sensorEvent.values[0]);

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

}