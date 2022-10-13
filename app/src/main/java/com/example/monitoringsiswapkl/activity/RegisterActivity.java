package com.example.monitoringsiswapkl.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.monitoringsiswapkl.R;

public class RegisterActivity extends AppCompatActivity {

    String textUser,textPassword;
    EditText user,pass,conpass;
    AppCompatButton btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user =findViewById(R.id.username);
        pass =findViewById(R.id.password);
        conpass=findViewById(R.id.confirPass);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}