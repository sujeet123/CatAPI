package com.sujeetkumar.catapp.application.dagger.module;

import com.sujeetkumar.catapp.application.dagger.scope.ActivityScope;
import com.sujeetkumar.catapp.presenter.caturday.CaturdayPresenter;
import com.sujeetkumar.catapp.view.common.activity.BaseDaggerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final BaseDaggerActivity baseDaggerActivity;

    public ActivityModule(BaseDaggerActivity activity) {
        baseDaggerActivity = activity;
    }

    @ActivityScope
    @Provides
    CaturdayPresenter provideCaturdayPresenter() {
        return new CaturdayPresenter();
    }

}
