package br.com.letscode.letsgoal.exception;

public class ClubeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClubeNotFoundException(String msg){
        super(msg);
    }

    public ClubeNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
