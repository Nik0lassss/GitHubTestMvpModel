package com.chirkevich.nikola.githubtestmvpmodel.data.remote;


import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserRequest;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by nikolay on 15.11.2017.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GIT_HUB_USER).addPathParameter(request).build().getObjectObservable(UserResponse.class);
    }

    @Override
    public Observable<List<RepositrotyResponse>> doGitHubGetUserRepositoriesCall(UserRequest.GitHubGetUserRepositoriesRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GIT_HUB_USER_REPOSITORIES).addPathParameter(request).build().getObjectListObservable(RepositrotyResponse.class);
    }
}
