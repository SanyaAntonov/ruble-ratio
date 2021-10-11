package ru.antonov.rubleratio;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Giphy", url = "https://api.giphy.com/v1/gifs/random")
public interface GiphyClient {
}
