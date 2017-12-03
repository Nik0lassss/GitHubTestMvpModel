package com.chirkevich.nikola.githubtestmvpmodel.ui.base;

import com.androidnetworking.error.ANError;
import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.exceptions.MvpViewNotAttachedException;
import com.chirkevich.nikola.githubtestmvpmodel.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Колян on 01.12.2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "presenter";

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    private V mvpView;

    @Inject
    public BasePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    public V getMvpView() {
        return mvpView;
    }


    public boolean isViewAttached() {
        return mvpView != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        mvpView = null;
    }

    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
