package br.com.letscode.letsgoal.service.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id){
        super("Resource not found. id: " + id);
    }
}
