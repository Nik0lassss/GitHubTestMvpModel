package com.chirkevich.nikola.githubtestmvpmodel.data;

import com.chirkevich.nikola.githubtestmvpmodel.data.local.db.DbHelper;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.remote.ApiHelper;


import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Колян on 02.12.2017.
 */

public interface DataManager extends DbHelper , ApiHelper {

    void setUserAsLoggedOut();

    @Override
    Observable<Boolean> insertUser(final com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User user);

    @Override
    Observable<List<Repository>> getAllRepositories();

    @Override
    Observable<Boolean> saveRepository(Repository repository);
}
