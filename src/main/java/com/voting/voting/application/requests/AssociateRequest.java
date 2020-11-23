package com.voting.voting.application.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.voting.voting.domain.validators.AssociateValidator;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AssociateRequest {

    @NotBlank(message = "Name cannot be blank")
    protected String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid email address")
    protected String email;

    @NotBlank(message = "CPF cannot be blank")
    @Size(min = 11, max = 11, message = "CPF must be exactly 11 characters")
    @CPF(message = "Invalid CPF")
    protected String cpf;

    public AssociateRequest() {
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        if (!AssociateValidator.isValidCpf(cpf)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid CPF.");
        }
        this.cpf = cpf;
    }
}
