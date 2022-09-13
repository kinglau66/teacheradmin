package com.king.teacher.service;

public class EntityMissingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityMissingException(String entityName) {
        super(entityName +" does not exists!");
    }
}
