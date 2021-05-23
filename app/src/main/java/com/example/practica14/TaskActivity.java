package com.example.practica14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private EditText nombreET, descripcionET;
    private Button agregarBtn;
    private ListView tareaLista;
    private TaskAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        db=FirebaseDatabase.getInstance();

        nombreET=findViewById(R.id.nombreET);
        descripcionET=findViewById(R.id.descripcionET);
        agregarBtn=findViewById(R.id.agregarBtn);
        tareaLista=findViewById(R.id.tareaLista);

        agregarBtn.setOnClickListener(this);

        tareaLista.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.agregarBtn:

                String id = db.getReference().child("tareas").push().getKey();
                DatabaseReference reference = db.getReference().child("tareas").child(id);

                break;
        }
    }

}