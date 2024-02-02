package ru.oogis.service.imitators;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.oogis.model.SignalRequest;

@Component
public class JarImitator implements Imitator {
    @Override
    public ResponseEntity<SignalRequest> run(SignalRequest request) {
/*
        StringBuilder command = new StringBuilder("java");
        for (String parameter : request.getParameters()) {
            command.append(parameter).append(" ");
        }

        String URL = request.getIp() + ":" + request.getPort();

        Map<String, String> response = new HashMap<>();
        response.put("command", command.toString());

        /*
         * Here we can implement logic of executing or sending the command
         * * /

        restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(response), Map.class);
*/

        SignalRequest responseBody =
                new SignalRequest(request.getMode(), request.getIp(), request.getPort(), request.getParameters());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
