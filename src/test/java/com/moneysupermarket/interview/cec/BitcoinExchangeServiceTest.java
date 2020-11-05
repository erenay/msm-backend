package com.moneysupermarket.interview.cec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BitcoinExchangeServiceTest {

    @Mock
    WebClient client;

    @Mock
    BitcoinExchangeWebClientBuilder clientBuilder;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<Map<String, Map<String, String>>> responseMock;

    @InjectMocks
    BitcoinExchangeService bitcoinExchangeService;

    @Test
    public void testGetRatesFromURL() throws Exception {

        when(clientBuilder.buildWebClient(anyString())).thenReturn(client);
        when(client.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri(any(Function.class))).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Map.class)).thenReturn(Mono.just(new HashMap()));

        Map<String, Map> responseMap = bitcoinExchangeService.getRatesFromURL("test");

        assertTrue(responseMap != null);

    }
}

