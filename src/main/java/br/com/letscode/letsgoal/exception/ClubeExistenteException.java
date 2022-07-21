package br.com.letscode.letsgoal.exception;

public class ClubeExistenteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClubeExistenteException(String msg){
        super(msg);
    }

    public ClubeExistenteException(String msg, Throwable cause){
        super(msg, cause);
    }
}
