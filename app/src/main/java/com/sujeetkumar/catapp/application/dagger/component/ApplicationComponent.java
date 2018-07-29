package com.sujeetkumar.catapp.application.dagger.component;

import com.sujeetkumar.catapp.application.dagger.module.ActivityModule;
import com.sujeetkumar.catapp.application.dagger.module.ApplicationModule;
import com.sujeetkumar.catapp.ui.fragments.BaseDaggerFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends DaggerComponent {
    void inject(BaseDaggerFragment fragment);

    ActivityComponent with(ActivityModule module);
}
