package com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Колян on 02.12.2017.
 */

public interface DbHelperTest {

  Observable<List<User>> getAllUsers();
}
