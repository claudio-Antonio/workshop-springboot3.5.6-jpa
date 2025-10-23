package com.exemplospring.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    /*Nesse construtor se passa o id que não foi encontrada e depoislança a exceção com a msg de erro.*/
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
