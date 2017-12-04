package com.chirkevich.nikola.githubtestmvpmodel.ui.main;


import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.MvpView;

import java.util.List;

/**
 * Created by Колян on 03.12.2017.
 */

public interface MainMvpView extends MvpView {
    void updateRespositories(List<Repository> repositories);
    void setUserName(UserResponse userResponse);
}
