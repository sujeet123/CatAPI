package com.sujeetkumar.catapp.view.common.activity;

import android.support.v7.app.AppCompatActivity;

import com.sujeetkumar.catapp.application.CaturdayApplication;
import com.sujeetkumar.catapp.application.dagger.component.ApplicationComponent;
import com.sujeetkumar.catapp.application.dagger.component.DaggerComponent;


public abstract class BaseDaggerActivity<C extends DaggerComponent> extends AppCompatActivity {

    protected CaturdayApplication getApplicationInstance() {
        return (CaturdayApplication) getApplication();
    }

    protected ApplicationComponent getApplicationComponent() {
        return getApplicationInstance().getApplicationComponent();
    }

    protected abstract C getDaggerComponent();

    protected abstract void init();

    protected abstract void destroy();

}
