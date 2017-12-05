package com.chirkevich.nikola.githubtestmvpmodel;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper.AppDbHelperTest;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Колян on 03.12.2017.
 */

public class TestDb {


    @Test
    public void getUser_isCorrect() throws Exception {



        AppDbHelperTest appDbHelperTest = new AppDbHelperTest();


        appDbHelperTest.getAllUsers().subscribe(new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<User> users) {
                assertNotNull(users);
                for (User user : users) {
                    assertNotNull(user.getId());
                    assertNotNull(user.getName());
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
