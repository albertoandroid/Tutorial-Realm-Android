package com.androiddesdecero.realmandroid.crud;

import android.util.Log;

import com.androiddesdecero.realmandroid.model.Profesor;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by albertopalomarrobledo on 16/4/18.
 */

public class CRUPProfesor {
    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Profesor.class).max("id");
        int nextId;
        if(currentIdNum == null){
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue()+1;
        }
        return nextId;
    }
    public final static void addProfesor(final Profesor profesor){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                int index = CRUPProfesor.calculateIndex();
                Profesor realmProfesor = realm.createObject(Profesor.class, index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });
    }
    public final static List<Profesor> getAllProfesor(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
        for(Profesor profesor: profesors){
            Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesors;
    }
    public final static Profesor getProfesorByName(String name){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name", name).findFirst();
        if(profesor != null){
            Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesor;
    }
    public final static Profesor getProfesorById(int id){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        if(profesor != null){
            Log.d("TAG", "id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesor;
    }

}
