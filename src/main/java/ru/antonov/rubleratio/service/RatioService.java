package ru.antonov.rubleratio.service;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.antonov.rubleratio.feignclients.GiphyClient;
import ru.antonov.rubleratio.feignclients.OpenExchangeRatesClient;
import ru.antonov.rubleratio.model.OpenExchangeRatesModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class RatioService {
    private final GiphyClient giphyClient;
    private final OpenExchangeRatesClient openExchangeRatesClient;
    private final Environment env;

    public Object compareRubleTo(String currencyCode) {
        OpenExchangeRatesModel today = openExchangeRatesClient.getModel(
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),
                env.getProperty("oer.app_id"),
                env.getProperty("oer.base"));
        OpenExchangeRatesModel yesterday = openExchangeRatesClient.getModel(
                LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE),
                env.getProperty("oer.app_id"),
                env.getProperty("oer.base"));

        BigDecimal todayRatio = today.getRates().get(currencyCode);
        BigDecimal yesterdayRatio = yesterday.getRates().get(currencyCode);

        if (todayRatio.compareTo(yesterdayRatio) > 0) {
            return giphyClient.getModelByTag(env.getProperty("giphy.api_key"), "rich");
        } else
            return giphyClient.getModelByTag(env.getProperty("giphy.api_key"), "broke");
    }
}
