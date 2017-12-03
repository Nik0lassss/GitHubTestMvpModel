package com.chirkevich.nikola.githubtestmvpmodel.di.module;

import android.app.Application;
import android.content.Context;

import com.chirkevich.nikola.githubtestmvpmodel.data.AppDataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper.AppDbHelperTest;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper.DbHelperTest;
import com.chirkevich.nikola.githubtestmvpmodel.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Колян on 02.12.2017.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication()
    {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelperTest provideDbHelper(AppDbHelperTest appDbHelperTest) {
        return appDbHelperTest;
    }


}
