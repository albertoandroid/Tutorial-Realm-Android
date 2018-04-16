package com.androiddesdecero.realmandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androiddesdecero.realmandroid.R;
import com.androiddesdecero.realmandroid.crud.CRUPProfesor;
import com.androiddesdecero.realmandroid.model.Profesor;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEt, emailEt;
    private Button saveBt, leerTodoBt, leerByName, leerById;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView(){
        profesor = new Profesor();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        emailEt = findViewById(R.id.mainActivityEtEmail);
        saveBt = findViewById(R.id.mainActivityBtSave);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profesor.setName(nombreEt.getText().toString());
                profesor.setEmail(emailEt.getText().toString());
                CRUPProfesor.addProfesor(profesor);
            }
        });
        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUPProfesor.getAllProfesor();
            }
        });
        leerByName = findViewById(R.id.mainActivityBtReadByName);
        leerByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUPProfesor.getProfesorByName(nombreEt.getText().toString());
            }
        });
        leerById = findViewById(R.id.mainActivityBtReadById);
        leerById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUPProfesor.getProfesorById(Integer.parseInt(nombreEt.getText().toString()));
            }
        });
    }
}
