package com.github.api.parkingcontrol.backend.config.exceptions.exceptionsconfigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
public class ExceptionDetails {

    protected String title;
    protected int status;
    protected String details;
    protected String developersMessage;
    protected LocalDateTime timeStamp;
}
