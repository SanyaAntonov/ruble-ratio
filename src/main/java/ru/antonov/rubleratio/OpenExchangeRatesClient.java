package ru.antonov.rubleratio;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "OpenExchangeRates", url = "https://openexchangerates.org/api/historical")
public interface OpenExchangeRatesClient {
}
