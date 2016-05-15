package bit.dail3.sensormovementanimation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;
    private lightSensor lightsensor;
    private ImageView imageView;
    private TextView textView;
    private int[] values;
    private boolean getValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        values = new int[2];
        getValue = false;
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        lightsensor = new lightSensor();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        sensorManager.unregisterListener(lightsensor);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(lightsensor, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    class lightSensor implements SensorEventListener
    {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            if((values[0] == 0) && (!getValue)){
                imageView.getLocationInWindow(values);
            }
            else {
                getValue = true;
                values[0] = (int) (values[0] - x);
                values[1] = (int) (values[1] + y);
                imageView.setX(values[0]);
                imageView.setY(values[1]);
                textView.setText(values[0] + "\n" + values[1]);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }
}
