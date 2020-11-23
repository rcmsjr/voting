package com.voting.voting.domain.validators;

import com.voting.voting.infrastructure.repositories.http.PersonRepository;
import com.voting.voting.infrastructure.repositories.http.daos.PersonDao;

public class AssociateValidator {

    public static Boolean isValidCpf(String cpf) {
        PersonRepository personRepository = new PersonRepository();
        PersonDao personDao = personRepository.getStatusbyCpf(cpf);
        return personDao.getStatus();
    }
}
