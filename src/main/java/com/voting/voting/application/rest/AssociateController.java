package com.voting.voting.application.rest;

import java.util.List;

import javax.validation.Valid;

import com.voting.voting.application.requests.AssociateRequest;
import com.voting.voting.domain.entities.Associate;
import com.voting.voting.domain.services.AssociateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/associate")
public class AssociateController {

    @Autowired
    protected AssociateService associateService;

    @PostMapping(value = "")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Associate createAssociate(@Valid @RequestBody AssociateRequest associateRequest) {
        return associateService.create(associateRequest);
    }

    @GetMapping(value = "")
    @ResponseBody
    public List<Associate> getAllAssociates() {
        return associateService.list();
    }

    @GetMapping(value = "/{cpf}")
    @ResponseBody
    public Associate getAssociate(@PathVariable("cpf") String cpf) {
        return associateService.show(cpf);
    }
}
