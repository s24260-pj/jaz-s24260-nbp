package com.example.jazs24260nbp.service;

import com.example.jazs24260nbp.model.CurrencyTable;
import com.example.jazs24260nbp.model.CurrentRate;
import com.example.jazs24260nbp.model.Rate;
import com.example.jazs24260nbp.repository.NBPRepository;
import org.springframework.stereotype.Service;

@Service
public class NBPService {
    private final CurrencyTableService currencyTableService;
    private NBPRepository nbpRepository;

    public NBPService(NBPRepository nbpRepository, CurrencyTableService currencyTableService) {
        this.nbpRepository = nbpRepository;
        this.currencyTableService = currencyTableService;
    }

    public CurrentRate save(String currency, String startDate, String finishDate) {
        CurrencyTable currencyTable = currencyTableService.get(currency, startDate, finishDate);

        CurrentRate currentRate = new CurrentRate();
        currentRate.setCurrency(currency);
        currentRate.setStart_date(startDate);
        currentRate.setEnd_date(finishDate);
        currentRate.setRate((currencyTable.getRates().stream().mapToDouble(Rate::getMid).average()).orElse(-1));

        return this.nbpRepository.save(currentRate);
    }
}
