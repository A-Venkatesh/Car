package in.venkateshalive.car;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Magneto extends Activity {

    TextView contdis;

    public static float intaialmeg;
    public int su=0;
    public static float finalang;
    private float venkang;
    Handler handler=new Handler();

    private static SensorManager sensorService;
    private TextView sidestatus,angle;
    //  private MyCompassView compassView;
    private Sensor sensor;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //    compassView = new MyCompassView(this);
        //  setContentView(compassView);
        setContentView(R.layout.activity_magneto);

    //    sidestatus = (TextView)findViewById(R.id.textView2);
      //  angle = (TextView)findViewById(R.id.textView3);

        sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor != null) {
            sensorService.registerListener(mySensorEventListener, sensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
            Log.i("Compass MainActivity", "Registerered for ORIENTATION Sensor");
        } else {
            Log.e("Compass MainActivity", "Registerered for ORIENTATION Sensor");
            Toast.makeText(this, "ORIENTATION Sensor not found",
                    Toast.LENGTH_LONG).show();
            finish();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finalang= venkang;

                startActivity(new Intent(Magneto.this,Testcomplete.class));
            }
        },8000L);

        contdis=(TextView)findViewById(R.id.con);



        new CountDownTimer(8000, 1000) {
            public void onTick(long millisUntilFinished) {
                contdis.setText("" + millisUntilFinished / 1000
                );
            }

            public void onFinish() {
                contdis.setVisibility(View.INVISIBLE);
                // textViewLevelGained.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // angle between the magnetic north direction
            // 0=North, 90=East, 180=South, 270=West
          //  float venkang = event.values[0];
            venkang = event.values[0];
            // compassView.updateData(venkang);
            //angle.setText(""+ venkang);

            if(su<=5){

                intaialmeg = venkang;
                su=su+1;
            }



          //  sidestatus.setText(""+ intaialmeg);


        }
    };

    @Override

    protected void onDestroy() {
        super.onDestroy();
        if (sensor != null) {
            sensorService.unregisterListener(mySensorEventListener);
        }
    }

}
