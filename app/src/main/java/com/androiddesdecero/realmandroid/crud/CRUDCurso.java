package com.androiddesdecero.realmandroid.crud;

import com.androiddesdecero.realmandroid.R;
import com.androiddesdecero.realmandroid.model.Curso;
import com.androiddesdecero.realmandroid.model.Profesor;

import io.realm.Realm;

/**
 * Created by albertopalomarrobledo on 16/4/18.
 */

public class CRUDCurso {

    public final static void addCurso(final String profesorId, final Curso curso){
        int id = Integer.parseInt(profesorId);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesorRealm = realm.where(Profesor.class).equalTo("id", id).findFirst();
        profesorRealm.getCursos().add(curso);
        realm.insertOrUpdate(profesorRealm);
        realm.commitTransaction();
    }

    public final static void updateCursoByName(String name){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.setName("Realm Android");
        realm.insertOrUpdate(curso);
        realm.commitTransaction();
    }

    public final static void deleteCursoByName(String name){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.deleteFromRealm();
        realm.commitTransaction();
    }

}
