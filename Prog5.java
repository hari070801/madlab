package com.example.counterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonstart,buttonstop;
    TextView countervalue;
    public int counter=0;
    public boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonstart = (Button) findViewById(R.id.btnstart);
        buttonstart.setOnClickListener(this);
        buttonstop = (Button) findViewById(R.id.btnstop);
        buttonstop.setOnClickListener(this);
        countervalue = (TextView) findViewById(R.id.txtvalue);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(buttonstart)){
            counterStart();
        }else if(v.equals(buttonstop)){
            counterStop();
        }
    }

    private void counterStop() {
        this.running=false;
        buttonstart.setEnabled(true);
        buttonstop.setEnabled(false);
    }

    private void counterStart() {
        counter=0;
        running = true;
        new MyCounter().start();
        buttonstart.setEnabled(false);
        buttonstop.setEnabled(true);
    }

    Handler handler = new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message mes){
            countervalue.setText(String.valueOf(mes.what));
        }

    };

    class MyCounter extends Thread{
        public void run(){
            while(running){
                counter++;

                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
