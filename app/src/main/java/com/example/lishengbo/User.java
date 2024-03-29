package com.example.lishengbo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class User {
    @Id(autoincrement = true)
    long id;
    String name;
    String pass;
    String imgpath;
    @Generated(hash = 1919527878)
    public User(long id, String name, String pass, String imgpath) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.imgpath = imgpath;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return this.pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getImgpath() {
        return this.imgpath;
    }
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

}
