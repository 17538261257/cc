package com.example.lishengbo.api;

import android.app.Application;

public class GreendaoApp extends Application {
    private static GreendaoApp  app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static GreendaoApp getApp() {
        return app;
    }
}
