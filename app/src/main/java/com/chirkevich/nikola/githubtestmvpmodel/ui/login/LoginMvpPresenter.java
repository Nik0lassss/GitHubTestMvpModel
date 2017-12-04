package com.chirkevich.nikola.githubtestmvpmodel.ui.login;

import com.chirkevich.nikola.githubtestmvpmodel.di.PerActivity;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.MvpPresenter;

/**
 * Created by nikolay on 04.12.2017.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

}
