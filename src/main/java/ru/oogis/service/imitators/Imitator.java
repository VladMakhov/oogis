package ru.oogis.service.imitators;

import org.springframework.http.ResponseEntity;
import ru.oogis.model.SignalRequest;

public interface Imitator {
    ResponseEntity<SignalRequest> run(SignalRequest request);
}
