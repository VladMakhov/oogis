package ru.oogis.service.imitators;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.oogis.model.SignalRequest;

@Component
public class JsonImitator implements Imitator {
    @Override
    public ResponseEntity<SignalRequest> run(SignalRequest request) {
/*
        try {
            String response = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String URL = request.getIp() + ":" + request.getPort();

        restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(response), SignalRequest.class);
*/

        SignalRequest responseBody =
                new SignalRequest(request.getMode(), request.getIp(), request.getPort(), request.getParameters());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
