package com.moneysupermarket.interview.cec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BitcoinExchangeServiceIntegrationTest {

    BitcoinExchangeService bitcoinExchangeService = new BitcoinExchangeService();

    @Test
    public void testGetRatesFromURL() throws Exception {
        BitcoinExchangeWebClientBuilder bitcoinExchangeWebClientBuilder = new BitcoinExchangeWebClientBuilder();
        bitcoinExchangeService.setClientBuilder(new BitcoinExchangeWebClientBuilder());
        Map<String, Map> responseMap = bitcoinExchangeService.getRatesFromURL("https://blockchain.info/ticker");
        responseMap.values().stream().forEach(System.out::println);
        assertTrue(responseMap.containsKey("USD"));
        responseMap = bitcoinExchangeService.getRatesFromURL("https://api.exmo.com/v1/ticker");
        assertTrue(responseMap.containsKey("BTC_USD"));
        responseMap.values().stream().forEach(System.out::println);
    }
}

