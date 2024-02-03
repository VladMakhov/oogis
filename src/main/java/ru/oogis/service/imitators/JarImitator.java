package ru.oogis.service.imitators;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.oogis.model.SignalRequest;

@Component
public class JarImitator implements Imitator {
    @Override
    public ResponseEntity<SignalRequest> run(SignalRequest request) {

/*
        StringBuilder command = new StringBuilder("java").append(" ");
        for (String parameter : request.getParameters()) {
            command.append(parameter).append(" ");
        }

        RestTemplate restTemplate = new RestTemplate();
        String URL = request.getIp() + ":" + request.getPort();

        restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(command), String.class);
*/

        SignalRequest responseBody =
                new SignalRequest(request.getMode(), request.getIp(), request.getPort(), request.getParameters());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
