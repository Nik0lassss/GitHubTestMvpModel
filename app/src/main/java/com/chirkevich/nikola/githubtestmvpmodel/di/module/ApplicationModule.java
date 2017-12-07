package com.chirkevich.nikola.githubtestmvpmodel.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.chirkevich.nikola.githubtestmvpmodel.data.AppDataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.db.AppDatabase;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.db.AppDbHelper;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.db.DbHelper;
import com.chirkevich.nikola.githubtestmvpmodel.data.remote.ApiHelper;
import com.chirkevich.nikola.githubtestmvpmodel.data.remote.AppApiHelper;

import com.chirkevich.nikola.githubtestmvpmodel.di.ApplicationContext;
import com.chirkevich.nikola.githubtestmvpmodel.di.DatabaseInfo;
import com.chirkevich.nikola.githubtestmvpmodel.utils.AppConstants;

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
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }


    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName) {
        return Room.databaseBuilder(application, AppDatabase.class, dbName)
                .build();
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
