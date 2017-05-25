package lab2_205_07.uwaterloo.ca.lab2_205_07;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by Justin on 2017-05-18.
 *
 */

public class AccelerometerSensorListener implements SensorEventListener {

    private TextView output;
    private LineGraphView graph;
    private float[] reading = {0,0,0};
    private float[] filteredReading = {0,0,0};
    private double FILTER_CONSTANT = 4;

    public AccelerometerSensorListener(TextView output, LineGraphView graph){
        this.output = output;
        this.graph = graph;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION){
            for(int i =0; i < 3; i++){
                filteredReading[i] += (event.values[i] - filteredReading[i])/FILTER_CONSTANT;
            }
            graph.addPoint(filteredReading);
        }
    }

    public float[] getFilteredReading(){
        return filteredReading;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not used
    }
}
