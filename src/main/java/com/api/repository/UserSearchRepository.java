package com.api.repository;


import com.api.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSearchRepository extends ElasticsearchRepository<User, String> {
    Iterable<User> searchByName(String name);

    Iterable<User> findByNameContaining(String query);
}
