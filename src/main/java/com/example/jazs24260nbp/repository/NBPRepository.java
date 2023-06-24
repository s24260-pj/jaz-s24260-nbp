package com.example.jazs24260nbp.repository;

import com.example.jazs24260nbp.model.CurrencyTable;
import com.example.jazs24260nbp.model.CurrentRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NBPRepository extends JpaRepository<CurrentRate, CurrencyTable> {
    CurrentRate save(CurrentRate currentRate);
}