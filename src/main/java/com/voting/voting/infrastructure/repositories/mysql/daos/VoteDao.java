package com.voting.voting.infrastructure.repositories.mysql.daos;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class VoteDao {

    @Id
    @Column(name = "id", length = 11, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private TopicDao topic;

    @ManyToOne
    @JoinColumn(name = "associate_id", nullable = false)
    private AssociateDao associate;

    @Column(name = "yes", length = 1, nullable = false)
    private Integer yes;

    @Column(name = "no", length = 1, nullable = false)
    private Integer no;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TopicDao getTopic() {
        return this.topic;
    }

    public void setTopic(TopicDao topic) {
        this.topic = topic;
    }

    public AssociateDao getAssociate() {
        return this.associate;
    }

    public void setAssociate(AssociateDao associate) {
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

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt != null ? createdAt : new Timestamp(new Date().getTime());
    }

}
