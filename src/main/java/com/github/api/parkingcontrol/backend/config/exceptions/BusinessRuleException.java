package com.github.api.parkingcontrol.backend.config.exceptions;

import com.github.api.parkingcontrol.backend.config.exceptions.exceptionsconfigs.CustomRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessRuleException extends CustomRestException {
    public BusinessRuleException(String message) {
        super(message);
    }

    @Override
    protected String getDevMessage() {

        return "A requisição não foi aceita!";
    }
}
