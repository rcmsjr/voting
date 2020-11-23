package com.voting.voting.infrastructure.repositories.mysql;

import com.voting.voting.infrastructure.repositories.mysql.daos.VoteDao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<VoteDao, Integer> {
    @Query(value = "select MAX(v.id) as id, v.topic_id, MAX(v.associate_id) as associate_id, SUM(v.yes) as yes, SUM(v.no) as no, MAX(v.created_at) as created_at"
            + " from votes v where v.topic_id in (select t.id from topics t where t.uuid = ?1)", nativeQuery = true)
    VoteDao findByTopicUuid(String uuid);

    @Query("select ve from VoteDao ve where ve.topic in (select te.id from TopicDao te where te.uuid = ?1)")
    Iterable<VoteDao> findAllByTopicUuid(String uuid);

    @Query("select ve from VoteDao ve where ve.topic in (select te.id from TopicDao te where te.uuid = ?1)"
            + " AND ve.associate in (select ae.id from AssociateDao ae where ae.cpf = ?2)")
    Iterable<VoteDao> findAllByTopicUuidAndAssociateCpf(String uuid, String cpf);
}
