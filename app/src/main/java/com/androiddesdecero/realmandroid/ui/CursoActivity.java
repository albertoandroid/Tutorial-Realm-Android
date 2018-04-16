package com.androiddesdecero.realmandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androiddesdecero.realmandroid.R;
import com.androiddesdecero.realmandroid.crud.CRUDCurso;
import com.androiddesdecero.realmandroid.model.Curso;

public class CursoActivity extends AppCompatActivity {

    private EditText idProfesorEt, nameEt, duractionEt;
    private Button saveBt, updateBt, deleteBt;
    private Curso curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        configView();
    }

    private void configView(){
        curso = new Curso();
        idProfesorEt = findViewById(R.id.cursoActivityEtId);
        nameEt = findViewById(R.id.cursoActivityEtNombre);
        duractionEt = findViewById(R.id.cursoActivityEtDuracion);
        saveBt = findViewById(R.id.cursoActivityBtSalvar);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curso.setName(nameEt.getText().toString());
                curso.setDuration(duractionEt.getText().toString());
                CRUDCurso.addCurso(idProfesorEt.getText().toString(), curso);
            }
        });

        updateBt = findViewById(R.id.cursoActivityBtActualizar);
        updateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDCurso.updateCursoByName(nameEt.getText().toString());
            }
        });


        deleteBt = findViewById(R.id.cursoActivityBtBorrar);
        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDCurso.deleteCursoByName(nameEt.getText().toString());
            }
        });
    }
}
