package com.voting.voting.domain.entities;

import java.util.Date;
import java.util.List;

public class Associate {

    protected Integer id;
    protected String cpf;
    protected String name;
    protected String email;
    protected List<Vote> votes;
    protected Date createdAt;

    public Associate() {
    }

    public Associate(Integer id, String cpf, String name, String email, Date createdAt, List<Vote> votes) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.votes = votes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

}
