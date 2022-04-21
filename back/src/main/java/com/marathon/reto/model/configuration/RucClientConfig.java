package com.marathon.reto.model.configuration;

import com.marathon.reto.model.exception.MarathonGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class RucClientConfig {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RucClientConfig.class);

    public <T> T get(String url, ParameterizedTypeReference<T> responseType) {
        return callWebService(url, HttpMethod.GET, null, responseType);
    }

    private <T> T callWebService(String url, HttpMethod method, Object body, ParameterizedTypeReference<T> responseType) {
        ResponseEntity<T> response = null;
        HttpStatus httpStatus = null;
        HttpHeaders headers = null;
        try {
            response = restTemplate.exchange(url,
                    method,
                    getEntity(headers, body),
                    responseType);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error al consumir el servicio {}, {}", url, e.getMessage());
            httpStatus = e.getStatusCode();
        } catch (Exception e) {
            logger.error("Error en el servicio: {}, mensaje: {}", url, e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (response != null && response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        throw new MarathonGenericException.Builder().withCustomHttpStatus(httpStatus).build();
    }

    private HttpEntity<Object> getEntity(HttpHeaders headers, Object body) {
        if (headers == null) {
            return body != null ? new HttpEntity<>(body) : null;
        } else {
            return body != null ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
        }
    }

}
