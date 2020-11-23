package com.voting.voting.infrastructure.repositories.http;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voting.voting.infrastructure.repositories.http.daos.PersonDao;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    protected String baseUrl = "https://user-info.herokuapp.com/users/";
    protected HttpClient httpClient = HttpClientBuilder.create().build();

    public PersonDao getStatusbyCpf(String cpf) {
        PersonDao personDao = new PersonDao();
        try {
            HttpGet getMethod = new HttpGet(this.baseUrl + cpf);
            HttpResponse response = httpClient.execute(getMethod);
            Integer responseStatusCode = response.getStatusLine().getStatusCode();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseJsonNode = objectMapper.readTree(EntityUtils.toString(response.getEntity()));
            if (responseStatusCode == HttpStatus.SC_OK
                    && responseJsonNode.get("status").asText().equals(new String("ABLE_TO_VOTE"))) {
                personDao.setStatus(true);
            } else {
                personDao.setStatus(false);
            }
        } catch (IOException e) {
            // TODO Push trace to log
            // e.printStackTrace();
            personDao.setStatus(false);
        }

        return personDao;
    }
}
