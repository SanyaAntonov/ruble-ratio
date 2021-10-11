package ru.antonov.rubleratio;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Map;

@Getter
@Setter
public class OpenExchangeRatesModel {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, BigInteger> currencyList;
}
