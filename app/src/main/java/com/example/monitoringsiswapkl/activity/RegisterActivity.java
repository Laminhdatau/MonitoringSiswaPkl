package com.example.monitoringsiswapkl.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monitoringsiswapkl.R;
import com.example.monitoringsiswapkl.api.ApiInterface;
import com.example.monitoringsiswapkl.api.ApiServer;
import com.example.monitoringsiswapkl.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    String textUser,textPassword,textConPassword;
    EditText user;
    EditText pass;
    EditText conpass;
    AppCompatButton btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        conpass = findViewById(R.id.confirPass);

        btnRegis = findViewById(R.id.btnregis);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textUser = user.getText().toString();
                textPassword = pass.getText().toString();

//                Log.d("TAG","onCLick:"+user +" "+ pass);

                textConPassword = conpass.getText().toString();

                if (textConPassword.equals(textPassword)) {
                    moveToRegister(textUser, textPassword);
                } else {
                    pass.setError("Password tidak sama");
                }
            }
        });


    }

    private void moveToRegister(String user, String pass) {
//       Log.d("TAG","moveToRegister: "+user +" "+pass);
        ApiInterface apiInterface = ApiServer.getClient().create(ApiInterface.class);
        Call<ResponseLogin> call = apiInterface.register(textUser,textPassword);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

//                Log.d("TAG","onResponse:"+response.body().getMessage());


                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Berhasil Mendaftar", Toast.LENGTH_LONG).toString();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Gagal Mendaftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}