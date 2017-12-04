package com.chirkevich.nikola.githubtestmvpmodel.data.remote;



import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserRequest;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by nikolay on 15.11.2017.
 */

public interface ApiHelper {
    Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request);
    Observable<List<RepositrotyResponse>> doGitHubGetUserRepositoriesCall(UserRequest.GitHubGetUserRepositoriesRequest request);
}
