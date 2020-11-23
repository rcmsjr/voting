package com.voting.voting.infrastructure.repositories.http.daos;

public class PersonDao {

    protected Boolean status;

    public PersonDao(Boolean status) {
        this.status = status;
    }

    public PersonDao() {
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
