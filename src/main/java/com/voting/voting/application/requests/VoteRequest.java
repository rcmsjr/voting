package com.voting.voting.application.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class VoteRequest {

    @NotNull(message = "Vote cannot be null")
    protected Boolean vote;

    @NotBlank(message = "CPF cannot be blank")
    @Size(min = 11, max = 11, message = "CPF must be exactly 11 characters")
    @CPF(message = "Invalid CPF")
    protected String cpf;

    public VoteRequest() {
    }

    public Boolean getVote() {
        return this.vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
