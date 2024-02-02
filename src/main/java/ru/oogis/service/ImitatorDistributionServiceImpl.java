package ru.oogis.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.oogis.model.SignalRequest;
import ru.oogis.service.imitators.JarImitator;
import ru.oogis.service.imitators.JsonImitator;
import ru.oogis.service.imitators.ShScriptImitator;
import ru.oogis.validator.ImitatorSignalRequestValidator;

/**
 * Service that distributes incoming requests to specified imitators
 *
 * @author Vladislav Makhov
 */
@Service
public class ImitatorDistributionServiceImpl implements ImitatorDistributionService {

    private final ImitatorSignalRequestValidator imitatorSignalRequestValidator;
    private final JarImitator jarImitator;
    private final ShScriptImitator shScriptImitator;
    private final JsonImitator jsonImitator;

    public ImitatorDistributionServiceImpl(ImitatorSignalRequestValidator imitatorSignalRequestValidator, JarImitator jarImitator, ShScriptImitator shScriptImitator, JsonImitator jsonImitator) {
        this.imitatorSignalRequestValidator = imitatorSignalRequestValidator;
        this.jarImitator = jarImitator;
        this.shScriptImitator = shScriptImitator;
        this.jsonImitator = jsonImitator;
    }

    /**
     * Method with the help of {@link ImitatorSignalRequestValidator} validates incoming data
     * and delivers request to required method based on imitator number for further distribution
     *
     * @param imitatorNumber Unique identifier of imitator
     * @param request        {@link SignalRequest}
     * @return {@link SignalRequest}
     */
    @Override
    public ResponseEntity<SignalRequest> distribute(int imitatorNumber, SignalRequest request) {
        ResponseEntity<SignalRequest> errorResponse = new ResponseEntity<>(
                new SignalRequest(
                        request.getMode(),
                        request.getIp(),
                        request.getPort(),
                        request.getParameters()
                ),
                HttpStatus.BAD_REQUEST);

        if (
                !imitatorSignalRequestValidator.validateIp(request.getIp()) ||
                !imitatorSignalRequestValidator.validatePort(request.getPort())
        ) {
            return errorResponse;
        }

        /*
          Inside of methods below we can implement any logic we need,
          such as sending necessary signals to other servers, etc...
         */
        switch (imitatorNumber) {
            default:
                return errorResponse;
            case 1:
                return jsonImitator.run(request);
            case 2:
                return jarImitator.run(request);
            case 3:
                return shScriptImitator.run(request);
        }
    }
}
