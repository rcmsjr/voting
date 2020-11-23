package com.voting.voting.domain.entities;

import java.util.Date;
import java.util.UUID;

public class Topic {

    protected Integer id;

    protected UUID uuid;

    protected String title;

    protected String description;

    protected Date endAt;

    protected Integer voteYes;

    protected Integer voteNo;

    protected Date createdAt;

    public Topic() {
    }

    public Topic(Integer id, UUID uuid, String title, String description, Date endAt, Integer voteYes, Integer voteNo,
            Date createdAt) {
        this.id = id;
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.endAt = endAt;
        this.voteYes = voteYes;
        this.voteNo = voteNo;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndAt() {
        return this.endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Integer getVoteYes() {
        return this.voteYes;
    }

    public void setVoteYes(Integer voteYes) {
        this.voteYes = voteYes;
    }

    public Integer getVoteNo() {
        return this.voteNo;
    }

    public void setVoteNo(Integer voteNo) {
        this.voteNo = voteNo;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
