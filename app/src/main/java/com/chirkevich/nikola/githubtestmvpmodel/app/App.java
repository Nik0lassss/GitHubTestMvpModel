package com.chirkevich.nikola.githubtestmvpmodel.app;

import android.app.Application;

import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.di.component.ApplicationComponent;
import com.chirkevich.nikola.githubtestmvpmodel.di.component.DaggerApplicationComponent;
import com.chirkevich.nikola.githubtestmvpmodel.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by Колян on 02.12.2017.
 */

public class App extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);



    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
