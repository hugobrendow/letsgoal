package br.com.letscode.letsgoal.exception;

public class FormacaoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FormacaoNotFoundException(String msg){
        super(msg);
    }

    public FormacaoNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
