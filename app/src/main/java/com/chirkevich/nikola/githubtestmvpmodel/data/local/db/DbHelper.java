package com.chirkevich.nikola.githubtestmvpmodel.data.local.db;



import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by nikolay on 15.11.2017.
 */

public interface DbHelper {

    Observable<Boolean> insertUser(final User user);
    Observable<List<User>> getAllUsers();
    Observable<List<Repository>> getAllRepositories();

    Observable<Boolean> saveRepository(Repository repository);
}
