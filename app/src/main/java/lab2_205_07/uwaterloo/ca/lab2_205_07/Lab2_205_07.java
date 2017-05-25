package lab2_205_07.uwaterloo.ca.lab2_205_07;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

import ca.uwaterloo.sensortoy.LineGraphView;

public class Lab2_205_07 extends AppCompatActivity {

    TextView directionText;
    LineGraphView graph;
    AccelerometerSensorListener accelerometerSensorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_205_07);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        graph = new LineGraphView(getApplicationContext(), 100, Arrays.asList("x","y","z"));
        linearLayout.addView(graph);

        directionText = new TextView(getApplicationContext());
        directionText.setText("");
        directionText.setTextColor(Color.BLACK);
        directionText.setTextSize(40f);
        directionText.setPadding(10,50,10,10);
        linearLayout.addView(directionText);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensorListener = new AccelerometerSensorListener(directionText,graph);
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(accelerometerSensorListener, accelerometerSensor,SensorManager.SENSOR_DELAY_GAME);

    }
}
