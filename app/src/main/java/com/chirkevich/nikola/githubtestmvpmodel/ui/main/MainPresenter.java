package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.BasePresenter;
import com.chirkevich.nikola.githubtestmvpmodel.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Колян on 03.12.2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {

        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().getAllUsers().subscribeOn(getSchedulerProvider().io()).observeOn(getSchedulerProvider().ui()).subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {
                if(users!=null)
                {
                    getMvpView().updateUsers(users);
                }
                getMvpView().hideLoading();

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (!isViewAttached())
                {
                    return;
                }
                getMvpView().hideLoading();

            }
        }));

    }
}
