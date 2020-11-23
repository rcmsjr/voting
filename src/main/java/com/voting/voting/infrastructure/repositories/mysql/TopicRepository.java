package com.voting.voting.infrastructure.repositories.mysql;

import com.voting.voting.infrastructure.repositories.mysql.daos.TopicDao;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<TopicDao, Integer> {
    TopicDao findByUuid(String uuid);
}
