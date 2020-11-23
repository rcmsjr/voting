package com.voting.voting.domain.entities;

import java.util.Date;

public class Vote {

    protected Integer id;

    protected Topic topic;

    protected Associate associate;

    protected Integer yes;

    protected Integer no;

    protected Date createdAt;

    public Vote() {
    }

    public Vote(Integer id, Topic topic, Associate associate, Integer yes, Integer no, Date createdAt) {
        this.id = id;
        this.topic = topic;
        this.associate = associate;
        this.yes = yes;
        this.no = no;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Associate getAssociate() {
        return this.associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public Integer getYes() {
        return this.yes;
    }

    public void setYes(Integer yes) {
        this.yes = yes;
    }

    public Integer getNo() {
        return this.no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
