package ru.antonov.rubleratio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "OpenExchangeRates", url = "${oer.url}")
public interface OpenExchangeRatesClient {
    @GetMapping("{yyyy-MM-dd}.json?app_id={appId}&base={base}")
    OpenExchangeRatesModel getModel(@PathVariable("yyyy-MM-dd") String TodayDate,
                                    @PathVariable String appId,
                                    @PathVariable String base);
}
