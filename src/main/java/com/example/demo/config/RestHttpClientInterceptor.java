package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
public class RestHttpClientInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("============================response begin==========================================");
        log.info("Status code   : {}", response.getStatusCode());
        log.info("Status text   : {}", response.getStatusText());
        log.info("Headers       : {}", response.getHeaders());
        log.info("============================response end============================================");
    }
}
