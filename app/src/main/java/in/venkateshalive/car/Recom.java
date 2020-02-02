package in.venkateshalive.car;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Recom extends AppCompatActivity {
    TextView pre;
    String prestr,prestrs;
    String a="Comfort",b="Noise Less Cabin",c="Wheel condition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recom);
        pre = (TextView)findViewById(R.id.recomtextView);

        prestrs = TestVdetail.preferenceselected;
      //  pre.setText(""+prestr);
        float vibr= Result.cumilativevib;
        int noiser= Result.cumilativenoise;
        int wheelr= Result.wheelrat;

        if(prestrs.equals(a)){
            if(vibr>=9){
                prestr = "This is best matching car for your interest, Excellent Comfort ";
                pre.setText(""+prestr);

            }
            else if(vibr>=7){
               prestr ="This is good matching car for your interest, Good comfort";
                pre.setText(""+prestr);

            }
            else if(vibr>=5){
                prestr ="this not good match for your interest but still you can buy this,Not much comfort ";
                pre.setText(""+prestr);

            }
            else {
                        prestr="This Car is opposite to your interest please dont buy this, Dabba car";
                pre.setText(""+prestr);

            }

        }
        if(prestrs.equals(b)){
            if(noiser>=9){
                prestr = "This is best matching car for your interest,Sealed cabin ";
                pre.setText(""+prestr);

            }
            else if(noiser>=7){
                prestr ="This is good matching car for your interest,Peaceful cabin";
                pre.setText(""+prestr);

            }
            else if(noiser>=5){
                prestr ="this not good match for your interest but still you can buy this,noisy cabin ";
                pre.setText(""+prestr);

            }
            else {
                prestr="This Car is opposite to your interest please dont buy this,get ready for head ache ";
                pre.setText(""+prestr);

            }

        }

        if(prestrs.equals(c)){
            if(wheelr>=9){
                prestr = "This is best matching car for your interest,Smooth drive ";
                pre.setText(""+prestr);

            }
            else if(wheelr>=7){
                prestr ="This is good matching car for your interest,Stright drive";
                pre.setText(""+prestr);

            }
            else if(wheelr>=5){
                prestr ="this not good match for your interest but still you can buy this,Trouble drive ";
                pre.setText(""+prestr);

            }
            else {
                prestr="This Car is opposite to your interest please dont buy this,Go to hell";
                pre.setText(""+prestr);

            }

        }
      // pre.setText(""+prestr);

    }
}
