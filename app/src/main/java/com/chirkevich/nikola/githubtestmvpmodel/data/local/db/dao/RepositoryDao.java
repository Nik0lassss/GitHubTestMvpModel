package com.chirkevich.nikola.githubtestmvpmodel.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;

import java.util.List;

/**
 * Created by nikolay on 15.11.2017.
 */

@Dao
public interface RepositoryDao {

    @Query("SELECT * from repositories")
    List<Repository> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repository repository);

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void insert(List<Repository> repositories);

    @Delete
    void delete(Repository repository);
}
