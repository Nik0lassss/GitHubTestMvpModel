package com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Колян on 02.12.2017.
 */

@Singleton
public class AppDbHelperTest implements DbHelperTest {

    private DbValueGeneratorTest dbValueGeneratorTest;

    @Inject
    public AppDbHelperTest() {
        this.dbValueGeneratorTest = new DbValueGeneratorTest();
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return dbValueGeneratorTest.generateUserList(10);
            }
        });
    }
}
