package com.example.jazs24260nbp.service;

import com.example.jazs24260nbp.model.CurrencyTable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class CurrencyTableService {
    private final RestTemplate restTemplate;

    private final String NBPResourceUrl = "https://api.nbp.pl/api";
    private final String responseFormat = "?json";

    public CurrencyTableService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyTable get(String currency, String startDate, String finishDate) {
        LocalDate startDateTmp  = LocalDate.parse(startDate);
        LocalDate finishDateTmp = LocalDate.parse(finishDate);

        return restTemplate.getForEntity(
                this.NBPResourceUrl + "/exchangerates/rates/a/" + currency + "/" + startDateTmp + "/" + finishDateTmp + "/" + this.responseFormat,
                CurrencyTable.class
        ).getBody();
    }
}
