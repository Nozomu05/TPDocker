package com.ingnum.rentalservice.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BonjourController {

    @Value("${php.service.url}")
    private String phpServiceUrl;

    Logger logger = org.slf4j.LoggerFactory.getLogger(BonjourController.class);

    @GetMapping("/bonjour")
    public String bonjour() {
        return "bonjour";
    }

    @GetMapping("/bonjour-php")
    public String bonjourPhp() {
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Requesting PHP service at: " + phpServiceUrl);
        String response = restTemplate.getForObject(phpServiceUrl, String.class);
        return response;
    }

    @GetMapping("/customer/{name}")
    public String getCustomerAddress(@PathVariable String name) {
        return "l'adresse de " + name + " est 13 rue dareau";
    }
}
