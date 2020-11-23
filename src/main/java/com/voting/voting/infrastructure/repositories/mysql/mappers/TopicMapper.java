package com.voting.voting.infrastructure.repositories.mysql.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.voting.voting.domain.entities.Topic;
import com.voting.voting.infrastructure.repositories.mysql.daos.TopicDao;

public class TopicMapper {

    public static Topic toDomain(TopicDao topicDao) {
        return new Topic(topicDao.getId(), UUID.fromString(topicDao.getUuid()), topicDao.getTitle(),
                topicDao.getDescription(), new java.util.Date(topicDao.getEndAt().getTime()), null, null,
                new java.util.Date(topicDao.getCreatedAt().getTime()));
    }

    public static List<Topic> toDomain(Iterable<TopicDao> topicsDao) {
        List<Topic> topics = new ArrayList<Topic>();

        Iterator<TopicDao> topicsIterator = topicsDao.iterator();
        while (topicsIterator.hasNext()) {
            topics.add(toDomain(topicsIterator.next()));
        }
        return topics;
    }

    public static TopicDao toInfrastructure(Topic topic) {
        TopicDao topicDao = new TopicDao();
        topicDao.setId(topic.getId());
        topicDao.setUuid(topic.getUuid().toString());
        topicDao.setTitle(topic.getTitle());
        topicDao.setDescription(topic.getDescription());
        topicDao.setEndAt(new java.sql.Timestamp(topic.getEndAt().getTime()));
        topicDao.setCreatedAt(new java.sql.Timestamp(
                topic.getCreatedAt() != null ? topic.getCreatedAt().getTime() : new java.util.Date().getTime()));

        return topicDao;
    }

}
