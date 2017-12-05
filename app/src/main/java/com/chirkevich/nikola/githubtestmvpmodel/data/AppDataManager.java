package com.chirkevich.nikola.githubtestmvpmodel.data;

import android.content.Context;

import com.chirkevich.nikola.githubtestmvpmodel.data.DataManager;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.db.DbHelper;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserRequest;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.remote.ApiHelper;
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
    private final DbHelper dbHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, ApiHelper apiHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.mApiHelper = apiHelper;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public Observable<Boolean> insertUser(com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User user) {
        return null;
    }

    @Override
    public Observable<List<com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User>> getAllUsers() {
        return null;
    }

    @Override
    public Observable<List<Repository>> getAllRepositories() {
        return null;
    }

    @Override
    public Observable<Boolean> saveRepository(Repository repository) {
        return dbHelper.saveRepository(repository);
    }


    @Override
    public Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request) {
        return mApiHelper.doGitHubGetUserCall(request);
    }

    @Override
    public Observable<List<RepositrotyResponse>> doGitHubGetUserRepositoriesCall(UserRequest.GitHubGetUserRepositoriesRequest request) {
        return mApiHelper.doGitHubGetUserRepositoriesCall(request);
    }
}
