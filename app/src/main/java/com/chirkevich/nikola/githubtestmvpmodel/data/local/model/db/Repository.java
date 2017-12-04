package com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.UserResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by nikolay on 15.11.2017.
 */


@Entity(tableName = "repositories")
public class Repository {



    @SerializedName("id")
    @Expose
    @PrimaryKey
    public Integer id;
//    @SerializedName("owner")
//    @Expose
//    public UserResponse owner;
//    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("private")
    @Expose
    public Boolean _private;
    @SerializedName("fork")
    @Expose
    public Boolean fork;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
}
