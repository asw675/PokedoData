package com.example.betterwine.pokedodata.Model;

import android.support.v4.app.Fragment;

import io.realm.RealmObject;

public class douban extends RealmObject{
    private String str;
    private String Img;
    private String DataUrl;
    private String id;
    private String alt;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getDataUrl() {
        return DataUrl;
    }

    public void setDataUrl(String dataUrl) {
        DataUrl = dataUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
