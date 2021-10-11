package ru.antonov.rubleratio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RatioService {
    @Value("${openexchangerates.appid}")
    private String appId;
    @Value("${openexchangerates.base}")
    private String base;
    @Value("${giphy.api_key}")
    private String apiKey;
    private final GiphyClient giphyClient;
    private final OpenExchangeRatesClient openExchangeRatesClient;

    public RatioService(GiphyClient giphyClient, OpenExchangeRatesClient openExchangeRatesClient) {
        this.giphyClient = giphyClient;
        this.openExchangeRatesClient = openExchangeRatesClient;
    }

    public Object compareRubleTo(String currencyСode) {
        OpenExchangeRatesModel today = openExchangeRatesClient.getModel(
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE), appId, base);
        OpenExchangeRatesModel yesterday = openExchangeRatesClient.getModel(
                LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE), appId, base);

        BigDecimal todayRatio = today.getRates().get(currencyСode);
        BigDecimal yesterdayRatio = yesterday.getRates().get(currencyСode);

        if (todayRatio.compareTo(yesterdayRatio) >= 0) {
            return giphyClient.get(apiKey, "rich");
        } else
            return giphyClient.get(apiKey, "broke");
    }
}
