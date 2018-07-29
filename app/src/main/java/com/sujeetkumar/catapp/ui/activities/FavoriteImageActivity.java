package com.sujeetkumar.catapp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.sujeetkumar.catapp.R;
import com.sujeetkumar.catapp.application.dagger.component.ApplicationComponent;
import com.sujeetkumar.catapp.common.domain.Cat;
import com.sujeetkumar.catapp.ui.fragments.BaseDaggerFragment;
import com.sujeetkumar.catapp.ui.fragments.FavoriteCatImageDaggerFragment;
import com.sujeetkumar.catapp.view.common.activity.BaseDaggerActivity;

public class FavoriteImageActivity extends BaseDaggerActivity<ApplicationComponent> {

    public static final String MODEL_KEY = "cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        Bundle extras = getIntent().getExtras();
        Cat cat = (Cat) extras.get(MODEL_KEY);
        BaseDaggerFragment fragment = FavoriteCatImageDaggerFragment.newInstance(cat);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected ApplicationComponent getDaggerComponent() {
        return getApplicationComponent();
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_favorite_image);
    }

    @Override
    protected void destroy() {
    }
}
