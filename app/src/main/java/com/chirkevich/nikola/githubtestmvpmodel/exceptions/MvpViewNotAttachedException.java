package com.chirkevich.nikola.githubtestmvpmodel.exceptions;

/**
 * Created by Колян on 02.12.2017.
 */

public class MvpViewNotAttachedException extends RuntimeException {
    public MvpViewNotAttachedException() {
        super("\"Please call Presenter.onAttach(MvpView) before\" +\n" +
                "                    \" requesting data to the Presenter\"");
    }
}
