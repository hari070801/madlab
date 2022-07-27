package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btnadd,btnsub,btnmul,btndiv;
    Button btnclear,btnequal,btndot;
    EditText txtresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btnone);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btntwo);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btnthree);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btnfour);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btnfive);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btnsix);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btnseven);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btneight);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btnnine);
        btn9.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.btnzero);
        btn0.setOnClickListener(this);
        btnadd = (Button) findViewById(R.id.btnplus);
        btnadd.setOnClickListener(this);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnsub.setOnClickListener(this);
        btnmul = (Button) findViewById(R.id.btnmul);
        btnmul.setOnClickListener(this);
        btndiv = (Button) findViewById(R.id.btndiv);
        btndiv.setOnClickListener(this);
        btndot = (Button) findViewById(R.id.btndot);
        btndot.setOnClickListener(this);
        btnclear = (Button) findViewById(R.id.btnclear);
        btnclear.setOnClickListener(this);
        btnequal = (Button) findViewById(R.id.btnequal);
        btnequal.setOnClickListener(this);

        txtresult = (EditText) findViewById(R.id.txtresult);
        txtresult.setText("");

    }

    @Override
    public void onClick(View v) {
        if(v.equals(btn1))
            txtresult.append("1");
        if(v.equals(btn2))
            txtresult.append("2");
        if(v.equals(btn3))
            txtresult.append("3");
        if(v.equals(btn4))
            txtresult.append("4");
        if(v.equals(btn5))
            txtresult.append("5");
        if(v.equals(btn6))
            txtresult.append("6");
        if(v.equals(btn7))
            txtresult.append("7");
        if(v.equals(btn8))
            txtresult.append("8");
        if(v.equals(btn9))
            txtresult.append("9");
        if(v.equals(btn0))
            txtresult.append("0");
        if(v.equals(btndot))
            txtresult.append(".");
        if(v.equals(btnadd))
            txtresult.append("+");
        if(v.equals(btnsub))
            txtresult.append("-");
        if(v.equals(btnmul))
            txtresult.append("*");
        if(v.equals(btndiv))
            txtresult.append("/");
        if(v.equals(btnclear))
            txtresult.setText("");

        if(v.equals(btnequal))
        {
          try {
              String data = txtresult.getText().toString();
              if(data.contains("/")){
                  divide(data);
              } else if(data.contains("*")){
                  multi(data);
              }else if(data.contains("+")){
                  add(data);
              }else if(data.contains("-")){
                  sub(data);
              }
          }catch (Exception e){
              displayInvalidMessage("Invalid input");
          }
        }

    }

    private void displayInvalidMessage(String mes) {
        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();

    }

    private void sub(String data) {
        String[] operands = data.split(Pattern.quote("-")); //3 '-' 6
        if(operands.length==2){
            double operand1 = Double.parseDouble(operands[0]); //as we cant add 2 strings
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 - operand2;
            txtresult.setText(String.valueOf(result)); //value od double in string format
        }else{
            displayInvalidMessage("Invalid input");
        }
    }

    private void add(String data) {
        String[] operands = data.split(Pattern.quote("+")); //3 '-' 6
        if(operands.length==2){
            double operand1 = Double.parseDouble(operands[0]); //as we cant add 2 strings
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 + operand2;
            txtresult.setText(String.valueOf(result)); //value od double in string format
        }else{
            displayInvalidMessage("Invalid input");
        }
    }

    private void multi(String data) {
        String[] operands = data.split(Pattern.quote("*")); //3 '-' 6
        if(operands.length==2){
            double operand1 = Double.parseDouble(operands[0]); //as we cant add 2 strings
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 * operand2;
            txtresult.setText(String.valueOf(result)); //value od double in string format
        }else{
            displayInvalidMessage("Invalid input");
        }
    }

    private void divide(String data) {
        String[] operands = data.split(Pattern.quote("/")); //3 '-' 6
        if(operands.length==2){
            double operand1 = Double.parseDouble(operands[0]); //as we cant add 2 strings
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 / operand2;
            txtresult.setText(String.valueOf(result)); //value od double in string format
        }else{
            displayInvalidMessage("Invalid input");
        }
    }
}
