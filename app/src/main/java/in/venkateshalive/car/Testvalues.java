package in.venkateshalive.car;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Testvalues extends AppCompatActivity {
    private TextView testv1,testv2;
    private float testvv1,testvv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testvalues);


        testv1 = (TextView)findViewById(R.id.textView5);
        testv2 = (TextView)findViewById(R.id.textView6);

        testvv1 = AcconeAct.maxx;
        testvv2 = AcconeAct.maxy;


        testv1.setText(""+ testvv1);
        testv2.setText(""+ testvv2);

    }
}
