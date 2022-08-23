package com.joaovitorsb.projectmongodb.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(Object id){
        super("Object Id: " + id + " not founded!");
    }
}
