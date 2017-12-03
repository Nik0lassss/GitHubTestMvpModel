package com.chirkevich.nikola.githubtestmvpmodel.di.component;

import android.app.Application;
import android.content.Context;

import com.chirkevich.nikola.githubtestmvpmodel.app.App;
import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.di.ApplicationContext;
import com.chirkevich.nikola.githubtestmvpmodel.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Колян on 02.12.2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
