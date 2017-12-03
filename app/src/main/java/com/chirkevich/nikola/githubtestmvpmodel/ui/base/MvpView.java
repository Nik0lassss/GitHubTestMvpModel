package com.chirkevich.nikola.githubtestmvpmodel.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Колян on 01.12.2017.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(@StringRes int resId);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
