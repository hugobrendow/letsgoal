package br.com.letscode.letsgoal.exception;

import br.com.letscode.letsgoal.controller.PatrocinadorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerImpl {
    private Logger logger = LoggerFactory.getLogger(PatrocinadorController.class);

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(DataIntegrityViolationException ex) {
        logger.error("Erro ao processar request: ", ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body("Informação inválida, verifique seus dados");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.error("Erro ao processar request: ", ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    @ExceptionHandler(PatrocinadorNotFoundException.class)
    public ResponseEntity<StandardError> handlePatrocinadorNotFound(PatrocinadorNotFoundException e, HttpServletRequest request) {
        logger.error("Erro ao processar request: ", e.getLocalizedMessage());
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(FormacaoNotFoundException.class)
    public ResponseEntity<StandardError> handleFormacaoNotFound(FormacaoNotFoundException e, HttpServletRequest request) {
        logger.error("Erro ao processar request: ", e.getLocalizedMessage());
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ClubeNotFoundException.class)
    public ResponseEntity<StandardError> handleClubeNotFound(ClubeNotFoundException e, HttpServletRequest request) {
        logger.error("Erro ao processar request: ", e.getLocalizedMessage());
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ClubeExistenteException.class)
    public ResponseEntity<StandardError> handleClubeExistente(ClubeExistenteException e, HttpServletRequest request) {
        logger.error("Erro ao processar request: ", e.getLocalizedMessage());
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
