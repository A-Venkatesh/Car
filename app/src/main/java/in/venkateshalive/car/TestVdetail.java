package in.venkateshalive.car;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class TestVdetail extends Activity implements
        OnItemSelectedListener{
    Spinner s1,s2,sp1;
    public static String preferenceselected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vdetail);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        sp1 = (Spinner)findViewById(R.id.spinner4);
        s1.setOnItemSelectedListener(this);
        sp1.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        preferenceselected = String.valueOf(sp1.getSelectedItem());
         String sp1= String.valueOf(s1.getSelectedItem());
        //Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Maruthi")) {
            List<String> list = new ArrayList<String>();
            list.add("celerio");
            list.add("swift");
            list.add("dzire");
            list.add("ciaz");
            list.add("ertiga");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Mahindra")) {
            List<String> list = new ArrayList<String>();
            list.add("xylo");
            list.add("verito");
            list.add("scorpio");
            list.add("bolero");
            list.add("xuv500");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("Toyota")) {
            List<String> list = new ArrayList<String>();
            list.add("etios");
            list.add("corolla altis");
            list.add("innova");
            list.add("fortuner");
            list.add("land cruiser");

            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            s2.setAdapter(dataAdapter3);
        }
        if(sp1.contentEquals("Tata")) {
            List<String> list = new ArrayList<String>();
            list.add("nano");
            list.add("indica");
            list.add("indigo");
            list.add("safari");
            list.add("hexa");

            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter4.notifyDataSetChanged();
            s2.setAdapter(dataAdapter4);
        }
        if(sp1.contentEquals("Honda")) {
            List<String> list = new ArrayList<String>();
            list.add("amaze");
            list.add("jazz");
            list.add("city");
            list.add("CR-V");
            list.add("accord");

            ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter5.notifyDataSetChanged();
            s2.setAdapter(dataAdapter5);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void gotores(View v)
    {



            //  startActivity(new Intent(getApplicationContext(), NoiseoneAct.class));
            startActivity(new Intent(TestVdetail.this,Result.class));

    }
}