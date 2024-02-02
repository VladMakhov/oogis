package ru.oogis.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Class created to validate parameters of a simulation signal request
 *
 * @author Vladislav Makhov
 * */
@Component
public class ImitatorSignalRequestValidator {

    /**
     * Method validates IP address of a request to check if it`s in the pattern from 0.0.0.0 to 255.255.255.255
     *
     * @param ip a unique numeric identifier of a device in a computer network operating over the IP protocol.
     * */
    public boolean validateIp(String ip) {
        String[] fields = ip.split(Pattern.quote("."));

        if (fields.length != 4) return false;

        try {
            for (String field : fields) {
                int number = Integer.parseInt(field);
                if (number > 255 || number < 0) return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * Method validates Port number of a request to check if it`s in the pattern from 0 to 65535
     *
     * @param port a port or port number is a number assigned to uniquely identify
     * a connection endpoint and to direct data to a specific service
     * */
    public boolean validatePort(int port) {
        return (port >= 0 && port <= 65535);
    }

}
