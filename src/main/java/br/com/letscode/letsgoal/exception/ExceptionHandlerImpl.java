package br.com.letscode.letsgoal.exception;

import br.com.letscode.letsgoal.controller.PatrocinadorController;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerImpl {

    Logger logger = LoggerFactory.getLogger(PatrocinadorController.class);

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
    public ResponseEntity<String> handlePatrocinadorNotFound(PatrocinadorNotFoundException ex) {
        logger.error("Erro ao encontrar patrocinador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
}
