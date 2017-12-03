package com.chirkevich.nikola.githubtestmvpmodel.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by Колян on 01.12.2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
