package com.voting.voting.infrastructure.repositories.mysql.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.voting.voting.domain.entities.Associate;
import com.voting.voting.infrastructure.repositories.mysql.daos.AssociateDao;

public class AssociateMapper {

    public static Associate toDomain(AssociateDao associateDao) {
        return new Associate(associateDao.getId(), associateDao.getCpf(), associateDao.getName(),
                associateDao.getEmail(), new java.util.Date(associateDao.getCreatedAt().getTime()), null);
    }

    public static List<Associate> toDomain(Iterable<AssociateDao> associatesDao) {
        List<Associate> associates = new ArrayList<Associate>();

        Iterator<AssociateDao> associatesIterator = associatesDao.iterator();
        while (associatesIterator.hasNext()) {
            associates.add(toDomain(associatesIterator.next()));
        }
        return associates;
    }

    public static AssociateDao toInfrastructure(Associate associate) {
        AssociateDao associateDao = new AssociateDao();
        associateDao.setId(associate.getId());
        associateDao.setCpf(associate.getCpf());
        associateDao.setName(associate.getName());
        associateDao.setEmail(associate.getEmail());
        associateDao.setCreatedAt(
                new java.sql.Timestamp(associate.getCreatedAt() != null ? associate.getCreatedAt().getTime()
                        : new java.util.Date().getTime()));

        return associateDao;
    }
}
