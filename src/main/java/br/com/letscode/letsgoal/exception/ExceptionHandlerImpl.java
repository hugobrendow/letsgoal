package br.com.letscode.letsgoal.exception;

import br.com.letscode.letsgoal.controller.PatrocinadorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    public ResponseEntity<String> handlePatrocinadorNotFound(PatrocinadorNotFoundException ex) {
        logger.error("Erro ao encontrar patrocinador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(FormacaoNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(FormacaoNotFoundException ex) {
        logger.error("Erro ao encontrar formação: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(PosicaoNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(PosicaoNotFoundException ex) {
        logger.error("Erro ao encontrar posição: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(LetsClubeNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(LetsClubeNotFoundException ex) {
        logger.error("Erro ao encontrar Let's Clube: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EscudoNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(EscudoNotFoundException ex) {
        logger.error("Erro ao encontrar Escudo: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(JogadorNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(JogadorNotFoundException ex) {
        logger.error("Erro ao encontrar Jogador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(ClubeNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(ClubeNotFoundException ex) {
        logger.error("Erro ao encontrar Clube: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
}
