package ru.oogis.service;

import org.springframework.http.ResponseEntity;
import ru.oogis.model.SignalRequest;

public interface ImitatorDistributionService {
    ResponseEntity<SignalRequest> distribute(int imitatorNumber, SignalRequest request);
}
