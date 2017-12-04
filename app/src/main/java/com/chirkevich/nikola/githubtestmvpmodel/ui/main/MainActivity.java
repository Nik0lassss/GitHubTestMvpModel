package com.chirkevich.nikola.githubtestmvpmodel.ui.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.chirkevich.nikola.githubtestmvpmodel.R;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;
import com.chirkevich.nikola.githubtestmvpmodel.data.test.db.model.User;
import com.chirkevich.nikola.githubtestmvpmodel.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    MainAdapter mMainAdapter;

    @Inject
    LinearLayoutManager layoutManager;

    @BindView(R.id.users_recycler_view)
    RecyclerView usersRecyclerView;

    @BindView(R.id.user_name)
    TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    protected void setUp() {

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        usersRecyclerView.setLayoutManager(layoutManager);
        usersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        usersRecyclerView.setAdapter(mMainAdapter);
        mPresenter.onViewInitialized();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmnetDetached(String tag) {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void updateRespositories(List<Repository> repositories) {
            mMainAdapter.addItems(repositories);
    }

    @Override
    public void setUserName(UserResponse userResponse) {
        userNameTextView.setText(userResponse.getLogin());
    }
}
