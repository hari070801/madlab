package com.example.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText loginusername , loginpassword;
    Button loginbtn;

    String user,pwd;

    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginusername = (EditText) findViewById(R.id.txtloginuser);
        loginpassword = (EditText) findViewById(R.id.txtloginpwd);
        loginbtn = (Button) findViewById(R.id.btnlogin);
        loginbtn.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("data");
        user = bundle.getString("User"); //retrieve data from signup bundle
        pwd = bundle.getString("Pwd");

    }


    @Override
    public void onClick(View v) {
        String user1 = loginusername.getText().toString();
        String pwd1 = loginpassword.getText().toString();

        if(user.equals(user1) && pwd.equals(pwd1)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }else{
            count++;
            if(count==3){
                loginbtn.setEnabled(false);
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
