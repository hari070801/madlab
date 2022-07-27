package com.example.prog8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button onebtn,twobtn,threebtn,fourbtn,fivebtn;
    Button sixbtn,sevenbtn,eightbtn,ninebtn,zerobtn;
    Button delbtn,callbtn,savebtn;
    Button starbtn,hashbtn;
    EditText phonenumbertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onebtn = (Button) findViewById(R.id.btn1);
        onebtn.setOnClickListener(this);

        twobtn = (Button) findViewById(R.id.btn2);
        twobtn.setOnClickListener(this);

        threebtn = (Button) findViewById(R.id.btn3);
        threebtn.setOnClickListener(this);

        fourbtn = (Button) findViewById(R.id.btn4);
        fourbtn.setOnClickListener(this);

        fivebtn = (Button) findViewById(R.id.btn5);
        fivebtn.setOnClickListener(this);

        sixbtn = (Button) findViewById(R.id.btn6);
        sixbtn.setOnClickListener(this);

        sevenbtn = (Button) findViewById(R.id.btn7);
        sevenbtn.setOnClickListener(this);

        eightbtn = (Button) findViewById(R.id.btn8);
        eightbtn.setOnClickListener(this);

        ninebtn = (Button) findViewById(R.id.btn9);
        ninebtn.setOnClickListener(this);

        zerobtn = (Button) findViewById(R.id.btn0);
        zerobtn.setOnClickListener(this);

        starbtn = (Button) findViewById(R.id.btnstar);
        starbtn.setOnClickListener(this);

        hashbtn = (Button) findViewById(R.id.btnhash);
        hashbtn.setOnClickListener(this);

        callbtn = (Button) findViewById(R.id.btncall);
        callbtn.setOnClickListener(this);

        savebtn = (Button) findViewById(R.id.btnsave);
        savebtn.setOnClickListener(this);

        delbtn = (Button) findViewById(R.id.btndel);
        delbtn.setOnClickListener(this);

        phonenumbertext = (EditText) findViewById(R.id.textphonenum);
        phonenumbertext.setText("");


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String inputphonenum = phonenumbertext.getText().toString();

        switch (id){
            case R.id.btn0:
                phonenumbertext.append("0");
                break;
            case R.id.btn1:
                phonenumbertext.append("1");
                break;
            case R.id.btn2:
                phonenumbertext.append("2");
                break;
            case R.id.btn3:
                phonenumbertext.append("3");
                break;
            case R.id.btn4:
                phonenumbertext.append("4");
                break;
            case R.id.btn5:
                phonenumbertext.append("5");
                break;
            case R.id.btn6:
                phonenumbertext.append("6");
                break;
            case R.id.btn7:
                phonenumbertext.append("7");
                break;
            case R.id.btn8:
                phonenumbertext.append("8");
                break;
            case R.id.btn9:
                phonenumbertext.append("9");
                break;
            case R.id.btnstar:
                phonenumbertext.append("*");
                break;
            case R.id.btnhash:
                phonenumbertext.append("#");
                break;

            case R.id.btncall:
                callMethod(inputphonenum);
                break;
            case R.id.btnsave:
                saveMethod(inputphonenum);
                break;
            case R.id.btndel:
                int inputlength = inputphonenum.length();
                if(inputlength>0){
                    phonenumbertext.setText((inputphonenum.substring(0,inputlength-1)));
                }
                break;
        }
    }

    private void callMethod(String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + number);
        intent.setData(uri);
        startActivity(intent);
    }

    private void saveMethod(String inputphonenum) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,inputphonenum);
        startActivity(intent);
    }
}
