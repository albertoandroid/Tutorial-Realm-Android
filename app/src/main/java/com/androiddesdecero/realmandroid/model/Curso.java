package com.androiddesdecero.realmandroid.model;

import io.realm.RealmObject;

/**
 * Created by albertopalomarrobledo on 16/4/18.
 */

public class Curso extends RealmObject {

    private String name;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
