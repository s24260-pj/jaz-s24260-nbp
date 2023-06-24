package com.example.jazs24260nbp.controller;

import com.example.jazs24260nbp.model.CurrencyTable;
import com.example.jazs24260nbp.model.CurrentRate;
import com.example.jazs24260nbp.service.NBPService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange")
public class NBPController {
    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CurrentRate.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found currency.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "502",
                    description = "Bad Gateway.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "504",
                    description = "Gateway timeout.",
                    content = @Content
            )
    })
    @Operation(summary = "Get currency")
    @GetMapping("/{currency}")
    public ResponseEntity<CurrentRate> getCurrency(@PathVariable(value = "currency") String currency, @RequestParam String startDate, @RequestParam String finishDate) {
        return ResponseEntity.ok(this.nbpService.save(currency, startDate, finishDate));
    }
}
