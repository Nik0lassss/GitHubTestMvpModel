package com.chirkevich.nikola.githubtestmvpmodel.di.component;

import com.chirkevich.nikola.githubtestmvpmodel.ui.main.MainActivity;
import com.chirkevich.nikola.githubtestmvpmodel.di.PerActivity;
import com.chirkevich.nikola.githubtestmvpmodel.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by Колян on 03.12.2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
