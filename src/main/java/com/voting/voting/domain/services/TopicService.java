package com.voting.voting.domain.services;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.voting.voting.application.requests.TopicRequest;
import com.voting.voting.domain.entities.Topic;
import com.voting.voting.infrastructure.repositories.mysql.TopicRepository;
import com.voting.voting.infrastructure.repositories.mysql.VoteRepository;
import com.voting.voting.infrastructure.repositories.mysql.daos.TopicDao;
import com.voting.voting.infrastructure.repositories.mysql.daos.VoteDao;
import com.voting.voting.infrastructure.repositories.mysql.mappers.TopicMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    protected TopicRepository topicRepository;

    @Autowired
    protected VoteRepository voteRepository;

    public Topic create(TopicRequest topicRequest) {
        if (topicRequest.getEndAt() == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 1);
            topicRequest.setEndAt(new java.util.Date(calendar.getTimeInMillis()));
        }

        Topic topic = new Topic(null, UUID.randomUUID(), topicRequest.getTitle(), topicRequest.getDescription(),
                topicRequest.getEndAt(), null, null, null);

        TopicDao topicDao = topicRepository.save(TopicMapper.toInfrastructure(topic));

        return TopicMapper.toDomain(topicDao);
    }

    public Topic show(UUID uuid) {
        TopicDao topicDao = topicRepository.findByUuid(uuid.toString());
        Topic topic = TopicMapper.toDomain(topicDao);
        VoteDao voteDao = voteRepository.findByTopicUuid(uuid.toString());
        if (voteDao != null) {
            topic.setVoteYes(voteDao.getYes());
            topic.setVoteNo(voteDao.getNo());
        }
        return topic;
    }

    public List<Topic> list() {
        Iterable<TopicDao> topicsDao = topicRepository.findAll();
        List<Topic> topics = TopicMapper.toDomain(topicsDao);
        for (Topic topic : topics) {
            VoteDao voteDao = voteRepository.findByTopicUuid(topic.getUuid().toString());
            if (voteDao != null) {
                topic.setVoteYes(voteDao.getYes());
                topic.setVoteNo(voteDao.getNo());
            }
        }
        return topics;
    }

}
