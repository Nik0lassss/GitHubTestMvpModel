package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserRequest;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.BasePresenter;
import com.chirkevich.nikola.githubtestmvpmodel.utils.RepositoryResponseMapper;
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
        getCompositeDisposable().add(getDataManager().doGitHubGetUserCall(new UserRequest.GitHubLoginRequest("nik0lassss")).subscribeOn(getSchedulerProvider().io()).observeOn(getSchedulerProvider().ui()).subscribe(
                new Consumer<UserResponse>() {

                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        getMvpView().setUserName(userResponse);
                    }
                }
                , new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();

                    }
                }));

        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().doGitHubGetUserRepositoriesCall(new UserRequest.GitHubGetUserRepositoriesRequest("nik0lassss")).subscribeOn(getSchedulerProvider().io()).observeOn(getSchedulerProvider().ui()).subscribe(new Consumer<List<RepositrotyResponse>>() {
            @Override
            public void accept(List<RepositrotyResponse> repositrotyResponses) throws Exception {
                for (RepositrotyResponse repositrotyResponse : repositrotyResponses)
                    getDataManager().saveRepository(RepositoryResponseMapper.mapRepositoryResponseToRepository(repositrotyResponse));
                getMvpView().updateRespositories(repositrotyResponses);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (!isViewAttached()) {
                    return;
                }
                getMvpView().hideLoading();
            }
        }));

    }
}
