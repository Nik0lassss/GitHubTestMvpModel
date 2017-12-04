package com.chirkevich.nikola.githubtestmvpmodel.data.local.db;


import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by nikolay on 15.11.2017.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private AppDatabase appDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }



    @Override
    public Observable<Boolean> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                appDatabase.userDao().insert(user);
                return true;
            }
        });
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return appDatabase.userDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Repository>> getAllRepositories() {
        return Observable.fromCallable(new Callable<List<Repository>>() {
            @Override
            public List<Repository> call() throws Exception {
                return appDatabase.repositoryDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveRepository(final Repository repository) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                appDatabase.repositoryDao().insert(repository);
                return true;
            }
        });
    }
}
