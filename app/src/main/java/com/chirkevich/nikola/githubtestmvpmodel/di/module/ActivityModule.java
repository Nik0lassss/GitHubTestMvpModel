package com.chirkevich.nikola.githubtestmvpmodel.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.di.ActivityContext;
import com.chirkevich.nikola.githubtestmvpmodel.di.PerActivity;
import com.chirkevich.nikola.githubtestmvpmodel.ui.main.MainAdapter;
import com.chirkevich.nikola.githubtestmvpmodel.ui.main.MainMvpPresenter;
import com.chirkevich.nikola.githubtestmvpmodel.ui.main.MainMvpView;
import com.chirkevich.nikola.githubtestmvpmodel.ui.main.MainPresenter;
import com.chirkevich.nikola.githubtestmvpmodel.utils.rx.AppSchedulerProvider;
import com.chirkevich.nikola.githubtestmvpmodel.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Колян on 02.12.2017.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }


    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainPresenter<MainMvpView> mainMvpViewMainMvpPresenter)
    {
        return mainMvpViewMainMvpPresenter;
    }

    @Provides
    SchedulerProvider providerSchedulerProvider()
    {
        return new AppSchedulerProvider();
    }

    @Provides
    MainAdapter provideMainAdapter()
    {
        return new MainAdapter(new ArrayList<RepositrotyResponse>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity)
    {
        return new LinearLayoutManager(activity);
    }

}
