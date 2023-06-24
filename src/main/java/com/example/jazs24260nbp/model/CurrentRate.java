package com.example.jazs24260nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "nbp_jaz_final")
public class CurrentRate {

    @Id
    private Integer id;
    @NotBlank(message = "Currency is mandatory")
    @Size(min = 1, max = 255)
    @Schema(description = "Currency")
    private String currency;

    @NotBlank(message = "Start Date is mandatory")
    @Size(min = 1, max = 255)
    @Schema(description = "Start Date")
    private String start_date;

    @NotBlank(message = "End Date is mandatory")
    @Size(min = 1, max = 255)
    @Schema(description = "End Date")
    private String end_date;

    @NotBlank(message = "Rate is mandatory")
    @Size(min = 1, max = 255)
    @Schema(description = "Rate")
    private Double rate;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
