package br.com.letscode.letsgoal.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id) {
        super("Resource not found by the given id: " + id);
    }

    public ResourceNotFoundException(String value){
        super("Resource not found by the given value: " + value);
    }
}