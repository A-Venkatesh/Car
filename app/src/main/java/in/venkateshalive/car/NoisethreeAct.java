package in.venkateshalive.car;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class NoisethreeAct extends Activity {TextView mStatusView,maxnoisss;
    MediaRecorder mRecorder;
    Thread runner;
    TextView contdis;
    public static Double maxxnoi = 0.0d;
    Double summanoise,anoi=10.0d,bnoi=0.0d,cnoi=0.0d;
    private static double mEMA = 0.0;
    static final private double EMA_FILTER = 0.6;
    ArrayList<Double> noiselist = new ArrayList<Double>();

    final Runnable updater = new Runnable(){

        public void run(){
            updateTv();
        };
    };
    final Handler mHandler = new Handler();
    Handler handler=new Handler();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_noiseone);
       // mStatusView = (TextView) findViewById(R.id.status);
       // maxnoisss = (TextView) findViewById(R.id.maxnoiss);


        if (runner == null)
        {
            runner = new Thread(){
                public void run()
                {
                    while (runner != null)
                    {
                        try
                        {
                            Thread.sleep(1000);
                            Log.i("Noise", "Tock");
                        } catch (InterruptedException e) { };
                        mHandler.post(updater);

                    }
                }
            };
            runner.start();
            Log.d("Noise", "start runner()");
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(NoisethreeAct.this,Wheeltest.class));
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


    }

    public void onResume()
    {
        super.onResume();
        startRecorder();
    }

    public void onPause()
    {
        super.onPause();
        stopRecorder();
    }

    public void startRecorder(){
        if (mRecorder == null)
        {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null");
            try
            {
                mRecorder.prepare();
            }catch (java.io.IOException ioe) {
                android.util.Log.e("[Monkey]", "IOException: " +
                        android.util.Log.getStackTraceString(ioe));

            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " +
                        android.util.Log.getStackTraceString(e));
            }
            try
            {
                mRecorder.start();
            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " +
                        android.util.Log.getStackTraceString(e));
            }

            //mEMA = 0.0;
        }

    }
    public void stopRecorder() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public void updateTv(){
        // mStatusView.setText(Double.toString((getAmplitudeEMA())) + " dB");
        summanoise = soundDb(10);
       /*    anoi=anoi+summanoise;
        bnoi=bnoi+1.0d;
        cnoi=anoi/bnoi;
*/

        // mStatusView.setText(Double.toString((summanoise)) + " dB");
        if (maxxnoi<summanoise)
        {
            maxxnoi = summanoise;
        }
        // maxnoisss.setText(Double.toString((maxxnoi)) + " dB");


    }
    public double soundDb(double ampl){
        anoi =  20 * Math.log10(getAmplitudeEMA() / ampl);
        noiselist.add(anoi);
        return anoi;
    }
    public double getAmplitude() {
        if (mRecorder != null)
            return  (mRecorder.getMaxAmplitude());
        else
            return 0;

    }
    public double getAmplitudeEMA() {
        double amp =  getAmplitude();
        mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
        return mEMA;
    }

}