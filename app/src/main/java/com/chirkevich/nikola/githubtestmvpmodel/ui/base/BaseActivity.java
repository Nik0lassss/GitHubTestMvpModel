package com.chirkevich.nikola.githubtestmvpmodel.ui.base;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chirkevich.nikola.githubtestmvpmodel.app.App;
import com.chirkevich.nikola.githubtestmvpmodel.di.component.ActivityComponent;
import com.chirkevich.nikola.githubtestmvpmodel.di.component.DaggerActivityComponent;
import com.chirkevich.nikola.githubtestmvpmodel.di.component.DaggerApplicationComponent;
import com.chirkevich.nikola.githubtestmvpmodel.di.module.ActivityModule;

import butterknife.Unbinder;

/**
 * Created by Колян on 02.12.2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {


    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getComponent())
                .build();



    }
    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
