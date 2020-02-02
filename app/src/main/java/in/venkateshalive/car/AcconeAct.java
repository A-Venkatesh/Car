package in.venkateshalive.car;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcconeAct extends Activity implements SensorEventListener {
    TextView contdis;
    public static   float bx=-15.0f,maxx=-15.0f,ax=15.0f,minx=15.0f,by=-15.0f,maxy=-15.0f,ay=15.0f,miny=15.0f,bz=-15.0f,maxz=-15.0f,az=15.0f,minz=15.0f;
    private TextView xText, yText, zText, xaText, yaText, zaText, saText, maxxText,minxText, maxyText,minyText, maxzText,minzText;
    private Sensor mySensor;
    private SensorManager SM;

    public Double xa=0.0,ya=0.0,za=0.0,sa=0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accone);



        // Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        /*
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);

        xaText = (TextView)findViewById(R.id.xaText);
        yaText = (TextView)findViewById(R.id.yaText);
        zaText = (TextView)findViewById(R.id.zaText);

        saText = (TextView)findViewById(R.id.saText);

        maxxText = (TextView)findViewById(R.id.maxxText);
        minxText = (TextView)findViewById(R.id.minxText);
        maxyText = (TextView)findViewById(R.id.maxyText);
        minyText = (TextView)findViewById(R.id.minyText);
        maxzText = (TextView)findViewById(R.id.maxzText);
        minzText = (TextView)findViewById(R.id.minzText);
*/
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(AcconeAct.this,NoiseoneAct.class));
            }
        },10000L);


        contdis=(TextView)findViewById(R.id.con);



        new CountDownTimer(10000, 1000) {
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

    @Override
    public void onSensorChanged(SensorEvent event) {



        Float a;




        for (Float ve: event.values){

            sa = sa + 1;
            xa = xa + event.values[0];







            // a = event.values[0];
            //   if (event.values[0]>b){
            //     max =event.values[0];
            //   b=max;

            //}
            // else {
            //  max = ve ;
            //}









            ya = ya + event.values[1];
            za = za + event.values[2];


        }


        if (event.values[0]>=bx){
            maxx =event.values[0];
            bx=maxx;
        }

        if (event.values[0]<=ax)
        {

            minx =event.values[0];
            ax=minx;
        }



        if (event.values[1]>=by){
            maxy =event.values[1];
            by=maxy;
        }

        if (event.values[1]<=ay)
        {

            miny =event.values[1];
            ay=miny;
        }





        if (event.values[2]>=bz){
            maxz =event.values[2];
            bz=maxz;
        }

        if (event.values[2]<=az)
        {

            minz =event.values[2];
            az=minz;
        }




     /*   xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        xaText.setText(""+ xa);
        yaText.setText(""+ ya);
        zaText.setText(""+ za);
        saText.setText(""+ sa);

        maxxText.setText(""+ maxx);
        minxText.setText(""+ minx);

        maxyText.setText(""+ maxy);
        minyText.setText(""+ miny);

        maxzText.setText(""+ maxz);
        minzText.setText(""+ minz);
        */

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
