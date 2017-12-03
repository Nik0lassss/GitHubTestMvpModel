package com.chirkevich.nikola.githubtestmvpmodel.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.Unbinder;

/**
 * Created by Колян on 02.12.2017.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            mActivity = activity;
            mActivity.onFragmentAttached();
        }
    }

    public BaseActivity getBaseActivity()
    {
        return mActivity;
    }

    public void setUpUnBinder(Unbinder unBinder)
    {
        this.unbinder = unBinder;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if (unbinder != null)
        {
            unbinder.unbind();
        }
        super.onDestroy();
    }


    protected abstract void setUp(View view);

    public interface Callback {

        void onFragmentAttached();

        void onFragmnetDetached(String tag);
    }

}
