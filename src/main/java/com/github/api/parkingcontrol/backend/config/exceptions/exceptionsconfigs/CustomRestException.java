package com.github.api.parkingcontrol.backend.config.exceptions.exceptionsconfigs;

import org.apache.commons.lang3.StringUtils;

public abstract class CustomRestException extends RuntimeException {

    public String getTitle(){
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(getClass().getSimpleName()), " ");
    }

    public String getDevelopersMessage(){
        return this.getClass().getSimpleName() + ": " + getDevMessage();
    }

    protected abstract String getDevMessage();

    public CustomRestException(String message){
        super(message);
    }

}
