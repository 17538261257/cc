package com.example.lishengbo.Bean;

public class Linkman {

    String name;
    String hao;

    public Linkman(String name, String hao) {
        this.name = name;
        this.hao = hao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHao() {
        return hao;
    }

    public void setHao(String hao) {
        this.hao = hao;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "name='" + name + '\'' +
                ", hao='" + hao + '\'' +
                '}';
    }
}
