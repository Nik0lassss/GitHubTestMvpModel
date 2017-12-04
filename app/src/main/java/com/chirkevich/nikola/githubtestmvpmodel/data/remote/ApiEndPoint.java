package com.chirkevich.nikola.githubtestmvpmodel.data.remote;


import com.chirkevich.nikola.githubtestmvpmodel.BuildConfig;

/**
 * Created by nikolay on 15.11.2017.
 */

public class ApiEndPoint {
    public static final String ENDPOINT_GIT_HUB_USER = BuildConfig.BASE_URL + "/users"
            + "/{userId}";

}
