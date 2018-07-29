package com.sujeetkumar.catapp.application;

import android.app.Application;

import com.sujeetkumar.catapp.application.dagger.component.ApplicationComponent;
import com.sujeetkumar.catapp.application.dagger.component.DaggerApplicationComponent;
import com.sujeetkumar.catapp.application.dagger.module.ApplicationModule;

public class CaturdayApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
