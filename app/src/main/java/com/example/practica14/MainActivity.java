package com.example.practica14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userET;
    private Button ingresarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userET = findViewById(R.id.userET);
        ingresarBtn = findViewById(R.id.ingresarBtn);

        ingresarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ingresarBtn:

                String user=userET.getText().toString();

                if (user.isEmpty()){
                    Toast.makeText(this,"Digite el nombre de usuario",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(this, TaskActivity.class);
                startActivity(i);

                break;
        }
    }
}