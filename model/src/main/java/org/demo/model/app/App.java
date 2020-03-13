package org.demo.model.app;

import android.app.Application;

/**
 * create by TIAN FENG on 2020/3/13
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initContextHolder();
    }

    private void initContextHolder() {
        AppContextHolder.get().init(this);
    }

}
