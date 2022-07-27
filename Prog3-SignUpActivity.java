package com.example.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText signupusername , signuppassword;
Button btnsignup;

String RE = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$"; //min of 8 char

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupusername = (EditText) findViewById(R.id.txtsignupuser);
        signuppassword = (EditText) findViewById(R.id.txtsignuppwd);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = signupusername.getText().toString(); //retrieve data what I have written in username edittext -> gettext in string rep
        String password = signuppassword.getText().toString();
        if(validatePassword(password)){
            Toast.makeText(getBaseContext(),"valid password",Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle(); //it is used to pass data b/w activities
            bundle.putString("User",username);
            bundle.putString("Pwd",password);

            Intent intent = new Intent(this,Login.class); //to pass the info
                                                                       // send a gift wrap it with name and address passed via courier
                                                                      // bundle is my gift with name and add ie data passed with the help of intent
            intent.putExtra("data",bundle);
            startActivity(intent);
        }else{
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(RE);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
