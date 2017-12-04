package com.chirkevich.nikola.githubtestmvpmodel.utils;

import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.api.RepositrotyResponse;
import com.chirkevich.nikola.githubtestmvpmodel.data.local.model.db.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 04.12.2017.
 */

public class RepositoryResponseMapper {

    public static Repository mapRepositoryResponseToRepository(RepositrotyResponse repositrotyResponse) {
        Repository repository = new Repository();
        repository.description = repositrotyResponse.getDescription();
        repository.htmlUrl = repositrotyResponse.getHtmlUrl();
        repository.id = repositrotyResponse.getId();
        return repository;
    }

    public static List<Repository> mapListRepositoryResponseToListRepository(List<RepositrotyResponse> repositrotyResponses) {
        List<Repository> repositories = new ArrayList<>();
        for (RepositrotyResponse repositrotyResponse : repositrotyResponses)
            repositories.add(RepositoryResponseMapper.mapRepositoryResponseToRepository(repositrotyResponse));

        return repositories;
    }
}
