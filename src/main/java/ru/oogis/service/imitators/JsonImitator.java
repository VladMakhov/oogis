package ru.oogis.service.imitators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.oogis.model.SignalRequest;

@Component
public class JsonImitator implements Imitator {
    @Override
    public ResponseEntity<SignalRequest> run(SignalRequest request) {

//        ObjectMapper objectMapper = new ObjectMapper();
//        RestTemplate restTemplate = new RestTemplate();
//
//        String response;
//
//        try {
//            response = objectMapper.writeValueAsString(request);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        String URL = request.getIp() + ":" + request.getPort();
//
//        restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(response), String.class);

        SignalRequest responseBody =
                new SignalRequest(request.getMode(), request.getIp(), request.getPort(), request.getParameters());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
