package com.sujeetkumar.catapp.presenter;


import com.sujeetkumar.catapp.view.MvpView;

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

}
