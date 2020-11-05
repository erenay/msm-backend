package com.moneysupermarket.interview.cec;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BitcoinExchangeWebClientBuilder {

    WebClient buildWebClient(String url) {
        return WebClient.builder().baseUrl(url).build();
    }

}
