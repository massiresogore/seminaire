package com.warrios.seminaire.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String objectName, Integer id) {
        super("nous ne retrouvons pas "+ objectName+ " avec un id "+ id);
    }
}
