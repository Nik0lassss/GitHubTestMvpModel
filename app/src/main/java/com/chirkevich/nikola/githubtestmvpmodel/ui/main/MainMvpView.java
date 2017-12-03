package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.MvpView;

import java.util.List;

/**
 * Created by Колян on 03.12.2017.
 */

public interface MainMvpView extends MvpView {
    void updateUsers(List<User> users);
}
