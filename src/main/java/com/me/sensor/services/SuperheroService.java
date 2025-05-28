package com.me.sensor.services;

import com.me.sensor.models.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SuperheroService {
    private final RestTemplate restTemplate;
    // URL base de la API (asegúrate de que el token sea el correcto)
    private final String API_BASE_URL = "https://superheroapi.com/api/859048bc6222752783c358b397f2b2c0/";

    @Autowired
    public SuperheroService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Superhero getSuperheroById(String id) {
        String url = API_BASE_URL + id;
        return restTemplate.getForObject(url, Superhero.class);
    }
}
