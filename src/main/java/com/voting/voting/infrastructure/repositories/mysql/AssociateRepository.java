package com.voting.voting.infrastructure.repositories.mysql;

import com.voting.voting.infrastructure.repositories.mysql.daos.AssociateDao;

import org.springframework.data.repository.CrudRepository;

public interface AssociateRepository extends CrudRepository<AssociateDao, Integer> {
    AssociateDao findByCpf(String cpf);
}
