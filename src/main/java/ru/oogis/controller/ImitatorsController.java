package ru.oogis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oogis.model.SignalRequest;
import ru.oogis.service.ImitatorDistributionService;

@RestController
@RequestMapping("api/v1/imitators")
public class ImitatorsController {

    private final ImitatorDistributionService simulatorService;

    public ImitatorsController(ImitatorDistributionService simulatorService) {
        this.simulatorService = simulatorService;
    }

    @PostMapping("/im1")
    public ResponseEntity<SignalRequest> startSimulatorV1(@RequestBody SignalRequest request) {
        return simulatorService.distribute(1, request);
    }

    @PostMapping("/im2")
    public ResponseEntity<SignalRequest> startSimulatorV2(@RequestBody SignalRequest request) {
        return simulatorService.distribute(2, request);
    }

    @PostMapping("/im3")
    public ResponseEntity<SignalRequest> startSimulatorV3(@RequestBody SignalRequest request) {
        return simulatorService.distribute(3, request);
    }
}
