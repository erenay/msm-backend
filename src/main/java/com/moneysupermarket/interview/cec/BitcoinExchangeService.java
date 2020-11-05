package com.moneysupermarket.interview.cec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class BitcoinExchangeService {

    WebClient client;

    @Autowired
    BitcoinExchangeWebClientBuilder clientBuilder;

    public BitcoinExchangeService() {

    }

    public Map<String, Map> getRatesFromURL(String url) {
        client = clientBuilder.buildWebClient(url);
        return client.get().uri(uriBuilder -> uriBuilder.build()).retrieve().bodyToMono(Map.class).block();
    }

    public BitcoinExchangeWebClientBuilder getClientBuilder() {
        return clientBuilder;
    }

    public void setClientBuilder(BitcoinExchangeWebClientBuilder clientBuilder) {
        this.clientBuilder = clientBuilder;
    }
}
