package com.voting.voting.domain.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.voting.voting.application.requests.VoteRequest;
import com.voting.voting.domain.entities.Associate;
import com.voting.voting.domain.entities.Topic;
import com.voting.voting.domain.entities.Vote;
import com.voting.voting.infrastructure.repositories.mysql.VoteRepository;
import com.voting.voting.infrastructure.repositories.mysql.daos.VoteDao;
import com.voting.voting.infrastructure.repositories.mysql.mappers.VoteMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VoteService {

    @Autowired
    protected VoteRepository voteRepository;

    @Autowired
    protected AssociateService associateService;

    public Vote create(Topic topic, VoteRequest voteRequest) {
        if (new Date().after(topic.getEndAt())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "This topic has already expired.");
        }

        Iterable<VoteDao> votesIterator = voteRepository
                .findAllByTopicUuidAndAssociateCpf(topic.getUuid().toString(), voteRequest.getCpf());

        if (votesIterator.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "The associate has already voted for this topic.");
        }

        Associate associate = associateService.show(voteRequest.getCpf());

        Vote vote = new Vote(null, topic, associate, voteRequest.getVote() == true ? 1 : 0,
                voteRequest.getVote() == false ? 1 : 0, null);

        VoteDao voteDao = voteRepository.save(VoteMapper.toInfrastructure(vote));

        return VoteMapper.toDomain(voteDao);
    }

    public List<Vote> list(UUID uuid) {
        Iterable<VoteDao> votesDao = voteRepository.findAllByTopicUuid(uuid.toString());
        return VoteMapper.toDomain(votesDao);
    }
}
