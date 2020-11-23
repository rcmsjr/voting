package com.voting.voting.domain.services;

import java.util.List;

import com.voting.voting.application.requests.AssociateRequest;
import com.voting.voting.domain.entities.Associate;
import com.voting.voting.infrastructure.repositories.mysql.AssociateRepository;
import com.voting.voting.infrastructure.repositories.mysql.daos.AssociateDao;
import com.voting.voting.infrastructure.repositories.mysql.mappers.AssociateMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociateService {

    @Autowired
    protected AssociateRepository associateRepository;

    public Associate create(AssociateRequest associateRequest) {
        Associate associate = new Associate(null, associateRequest.getCpf(), associateRequest.getName(),
                associateRequest.getEmail(), null, null);

        AssociateDao associateDao = associateRepository.save(AssociateMapper.toInfrastructure(associate));

        return AssociateMapper.toDomain(associateDao);
    }

    public Associate show(String cpf) {
        AssociateDao associateDao = associateRepository.findByCpf(cpf);
        return AssociateMapper.toDomain(associateDao);
    }

    public List<Associate> list() {
        Iterable<AssociateDao> associatesDao = associateRepository.findAll();
        return AssociateMapper.toDomain(associatesDao);
    }

}
