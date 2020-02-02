package in.venkateshalive.car;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Result extends AppCompatActivity {
    public static float maxx,minx,maxy,miny,maxz,minz,stationvrat,topvibrat,cumilativevib;
    public static int stationnoiserat,gearnoiserat,topnoiserat,wheelrat,cumilativenoise;
    TextView at,bt,ct,dt,et,ft,gt,ht;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        at = (TextView)findViewById(R.id.svtextView);
        bt = (TextView)findViewById(R.id.sntextView);
        ct = (TextView)findViewById(R.id.gntextView);
        dt = (TextView)findViewById(R.id.tvtextView);
        et = (TextView)findViewById(R.id.tntextView);
        ft = (TextView)findViewById(R.id.wtextView);
        gt = (TextView)findViewById(R.id.cvtextView);
        ht = (TextView)findViewById(R.id.cntextView);

        //stationary vib rate one
       stationvrat = stationraterone();
        // stationnrat noi rate one
       stationnoiserat = stationnoiraterone();
//gear noi rate
        gearnoiserat = gearnoirater();

        //top gear vib
        topvibrat = topraterone();
//top gear noise level
        topnoiserat = topnoirater();

        wheelrat = whellanglecal();

        cumilativenoise = (stationnoiserat + gearnoiserat + topnoiserat)/3;
        cumilativevib = (stationvrat +topvibrat)/2;








at.setText(""+stationvrat);
        bt.setText(""+stationnoiserat);
        ct.setText(""+gearnoiserat);
        dt.setText(""+topvibrat);
        et.setText(""+topnoiserat);
        ft.setText(""+wheelrat);
        gt.setText(""+cumilativevib);
        ht.setText(""+cumilativenoise);
    }
    public void reci(View v)
    {
        startActivity(new Intent(Result.this,Recom.class));
    }


    public  int whellanglecal(){
        float i = Magneto.intaialmeg;
        float f = Magneto.finalang;
        float d=0,k;
        int r;

        if(f>i){
            d = f-i;
        }
        if (i>f){
            d = i-f;
        }
        if (d > 70) {
            if (f>i){
                k= 360-f;
                d=k+i;

            }
            if(i>f){
                k=360-i;
                d=k+f;
            }
        }
        r = whellalirater(d);
        return r;
    }

public int whellalirater(float a){
    if(a<=5){
        return 10;
    }

    else if(a<=10){
        return 10;
    }
    else if(a<=15){
        return 9;
    }
    else if(a<=20){
        return 8;
    }
    else if(a<=25){
        return 7;
    }
    else if(a<=30){
        return 6;
    }
    else if(a<=35){
        return 5;
    }
    else if(a<=40){return 4;}
    else if(a<=45){return 3;}
    else if(a<=50){return 2;}
    else if(a<=55){return 1;}
    else {return 0;

    }
}

    public  Double topNval(){
        Double a = NoisethreeAct.maxxnoi;


        return  a;

    }

    public  int topnoirater(){



        Double a = topNval();

        if(a<=20){
            return 10;
        }

        else if(a<=35){
            return 9;
        }
        else if(a<=40){
            return 8;
        }
        else if(a<=45){
            return 7;
        }
        else if(a<=50){
            return 6;
        }
        else if(a<=55){
            return 6;
        }
        else if(a<=60){
            return 6;
        }
        else if(a<=65){return 5;}
        else if(a<=70){return 5;}
        else if(a<=75){return 4;}
        else if(a<=80){return 3;}
        else {return 0;

        }

    }



    public float topv(){
        float a,b=-1,c,d,e;

        maxx = AcctwoAct.maxx;
        maxy = AcctwoAct.maxy;
        maxz = AcctwoAct.maxz;
        minx = AcctwoAct.minx;
        miny = AcctwoAct.miny;
        minz = AcctwoAct.minz;

        if (minx<0){
            minx = minx * b;
            c=maxx +minx;
        }
        else {
            c=maxx-minx;
        }
        if (miny<0){
            miny = miny * b;
            d=maxy +miny;
        }
        else {
            d=maxy-miny;
        }
        if (minz<0){
            minz = minz * b;
            e=maxz +minz;
        }
        else{
            e=maxz-minz;
        }


        a=c+d+e;






        return a;
    }

    public  float topraterone(){

        float a = topv();


        if(a<=10){
            return 10;
        }
        else if(a<=20){
            return 9;
        }
        else if(a<=30){
            return 8;
        }
        else if(a<=40){
            return 7;
        }
        else if(a<=50){
            return 6;
        }
        else if(a<=60){
            return 5;
        }
        else if(a<=70){
            return 4;
        }
        else if(a<=80){return 3;}
        else if(a<=90){return 2;}
        else if(a<=100){return 1;}
        else {return 0;

        }

    }



    public  Double gearNval(){
        Double a = NoisetwoAct.maxxnoi;


        return  a;

    }

    public  int gearnoirater(){



        Double a = gearNval();

        if(a<=20){
            return 10;
        }

        else if(a<=35){
            return 9;
        }
        else if(a<=40){
            return 8;
        }
        else if(a<=45){
            return 7;
        }
        else if(a<=50){
            return 6;
        }
        else if(a<=55){
            return 6;
        }
        else if(a<=60){
            return 6;
        }
        else if(a<=65){return 6;}
        else if(a<=70){return 5;}
        else if(a<=75){return 5;}
        else if(a<=80){return 4;}
        else {return 0;

        }

    }


    public  Double stationNval(){
        Double a = NoiseoneAct.maxxnoi;


        return  a;

    }

    public  int stationnoiraterone(){



            Double a = stationNval();

        if(a<=20){
            return 10;
        }

        else if(a<=35){
            return 10;
        }
        else if(a<=40){
            return 9;
        }
        else if(a<=45){
            return 8;
        }
        else if(a<=50){
            return 7;
        }
        else if(a<=55){
            return 6;
        }
        else if(a<=60){
            return 5;
        }
        else if(a<=65){return 4;}
        else if(a<=70){return 3;}
        else if(a<=75){return 2;}
        else if(a<=80){return 1;}
        else {return 0;

        }

    }

    public float stationv(){
        float a,b=-1,c,d,e;

        maxx = AcconeAct.maxx;
        maxy = AcconeAct.maxy;
        maxz = AcconeAct.maxz;
        minx = AcconeAct.minx;
        miny = AcconeAct.miny;
        minz = AcconeAct.minz;

        if (minx<0){
            minx = minx * b;
            c=maxx +minx;
        }
        else {
            c=maxx-minx;
        }
        if (miny<0){
            miny = miny * b;
            d=maxy +miny;
        }
        else {
            d=maxy-miny;
        }
        if (minz<0){
            minz = minz * b;
            e=maxz +minz;
        }
        else{
            e=maxz-minz;
        }


        a=c+d+e;






return a;
    }
public  float stationraterone(){

    float a = stationv();


    if(a<=10){
        return 10;
    }
    else if(a<=20){
        return 9;
    }
    else if(a<=30){
        return 8;
    }
    else if(a<=40){
        return 7;
    }
    else if(a<=50){
        return 6;
    }
    else if(a<=60){
        return 5;
    }
    else if(a<=70){
        return 4;
    }
    else if(a<=80){return 3;}
    else if(a<=90){return 2;}
    else if(a<=100){return 1;}
    else {return 0;

    }

    }
}
