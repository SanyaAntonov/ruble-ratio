package ru.antonov.rubleratio;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RatioController {
    private final RatioService ratioService;

    @GetMapping("{currencyCode}")
    public Object compare(@PathVariable String currencyCode){
        return ratioService.compareRubleTo(currencyCode);
    }
}
