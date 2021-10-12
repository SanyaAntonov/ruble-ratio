package ru.antonov.rubleratio;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class RatioController {
    private final RatioService ratioService;

    @GetMapping("compare/{currencyCode}")
    public Object compare(@PathVariable String currencyCode){
        log.info("Controller method compare, currencyCode: " + currencyCode);
        return ratioService.compareRubleTo(currencyCode);
    }
}
