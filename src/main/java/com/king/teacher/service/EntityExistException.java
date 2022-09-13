package com.king.teacher.service;

public class EntityExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityExistException(String entityName) {
        super(entityName +" is already in use!");
    }
}
