package com.chirkevich.nikola.githubtestmvpmodel.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.User;

import java.util.List;

/**
 * Created by nikolay on 15.11.2017.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Delete
    void delete(User user);
}
