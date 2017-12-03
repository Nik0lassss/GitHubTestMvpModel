package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import com.chirkevich.nikola.githubtestmvpmodel.di.PerActivity;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.MvpPresenter;

/**
 * Created by Колян on 03.12.2017.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V>  {
    void onViewInitialized();
}
