package ru.antonov.rubleratio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "Giphy", url = "https://api.giphy.com/v1/gifs/random")
public interface GiphyClient {

    @GetMapping("?api_key={apiKey}&tag={tag}")
    Object get(@PathVariable String apiKey,
             @PathVariable String tag);
}
