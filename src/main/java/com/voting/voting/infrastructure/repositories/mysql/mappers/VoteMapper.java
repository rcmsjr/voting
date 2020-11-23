package com.voting.voting.infrastructure.repositories.mysql.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.voting.voting.domain.entities.Vote;
import com.voting.voting.infrastructure.repositories.mysql.daos.VoteDao;

public class VoteMapper {

    public static Vote toDomain(VoteDao voteDao) {
        return new Vote(voteDao.getId(), null, null, voteDao.getYes(), voteDao.getNo(),
                new java.util.Date(voteDao.getCreatedAt().getTime()));
    }

    public static List<Vote> toDomain(Iterable<VoteDao> votesDao) {
        List<Vote> votes = new ArrayList<Vote>();

        Iterator<VoteDao> votesIterator = votesDao.iterator();
        while (votesIterator.hasNext()) {
            votes.add(toDomain(votesIterator.next()));
        }
        return votes;
    }

    public static VoteDao toInfrastructure(Vote vote) {
        VoteDao voteDao = new VoteDao();
        voteDao.setId(vote.getId());
        voteDao.setTopic(TopicMapper.toInfrastructure(vote.getTopic()));
        voteDao.setAssociate(AssociateMapper.toInfrastructure(vote.getAssociate()));
        voteDao.setYes(vote.getYes());
        voteDao.setNo(vote.getNo());
        voteDao.setCreatedAt(new java.sql.Timestamp(
                vote.getCreatedAt() != null ? vote.getCreatedAt().getTime() : new java.util.Date().getTime()));

        return voteDao;
    }

}
