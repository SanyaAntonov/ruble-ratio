package ru.antonov.rubleratio.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Giphy", url = "${giphy.random}")
public interface GiphyClient {
    @GetMapping("?api_key={apiKey}&tag={tag}")
    Object getModelByTag(@PathVariable String apiKey,
                         @PathVariable String tag);
}
