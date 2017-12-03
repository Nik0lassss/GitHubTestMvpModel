package com.chirkevich.nikola.githubtestmvpmodel.data;

import android.content.Context;

import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper.DbHelperTest;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Колян on 02.12.2017.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static String TAG = "AppDataManager";
    private Context context;
    private DbHelperTest dbHelperTest;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelperTest dbHelperTest) {
        this.context = context;
        this.dbHelperTest = dbHelperTest;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return dbHelperTest.getAllUsers();
    }
}
