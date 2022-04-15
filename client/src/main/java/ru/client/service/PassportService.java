package ru.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.client.model.Passport;

import java.util.Collections;
import java.util.List;

@Service
public class PassportService {

    private final String passport_API = "http://localhost:8080/passport";

    private final RestTemplate restTemplate;

    public PassportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Passport save(Passport passport) {
        return restTemplate.postForObject(passport_API, passport, Passport.class);
    }

    public void update(Passport passport) {
        restTemplate.put(passport_API, passport);
    }

    public Passport findById(int id) {
        return restTemplate.getForEntity(
                String.format("%s/getById/%s", passport_API, id),
                Passport.class
        ).getBody();
    }

    public void delete(int id) {
        restTemplate.delete(
                String.format("%s/%s", passport_API, id)
        );
    }

    public Passport findBySeries(int series) {
        return restTemplate.getForEntity(
                String.format("%s/getBySeries/%s" , passport_API, series),
                Passport.class
        ).getBody();
    }

    public List<Passport> findNotValid() {
        return getList(passport_API + "/notValid");
    }

    public List<Passport> getValidSoon() {
        return getList(passport_API + "/soonValid");
    }

    public List<Passport> findAll() {
        return getList(passport_API);
    }

    private List<Passport> getList(String url) {
        List<Passport> body = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }
}
