package com.example.lishengbo.persentr;

import com.example.lishengbo.User;
import com.example.lishengbo.callback.RegisCallback;
import com.example.lishengbo.model.RegisModel;
import com.example.lishengbo.view.RegisView;

public class RegisPersentr implements RegisCallback {

    RegisView regisView;
    private final RegisModel regisModel;

    public RegisPersentr(RegisView regisView) {
        this.regisView = regisView;
        regisModel = new RegisModel();


    }

    public void getData(User user) {
        regisModel.getData(user, this);
    }

    @Override
    public void ok(String s) {
        regisView.ok(s);
    }

    @Override
    public void no(String s) {
        regisView.no(s);
    }
}
