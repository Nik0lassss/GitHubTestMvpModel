package com.chirkevich.nikola.githubtestmvpmodel.data;

import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.helper.DbHelperTest;

/**
 * Created by Колян on 02.12.2017.
 */

public interface DataManager extends DbHelperTest {
    void setUserAsLoggedOut();
}
