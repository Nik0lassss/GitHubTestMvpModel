package com.chirkevich.nikola.githubtestmvpmodel.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Колян on 02.12.2017.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
