package br.com.letscode.letsgoal.exception;

import br.com.letscode.letsgoal.controller.PatrocinadorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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


    @ExceptionHandler(ClienteExistenteException.class)
    public ResponseEntity<String> handleClienteExistenteException(ClienteExistenteException ex) {
        logger.error("Erro ao salvar clube: ", ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Clube com nome, nome fantasia ou abreviação existente. Tente novamente.");
    }

    @ExceptionHandler(JogadorNotFoundException.class)
    public ResponseEntity<String> handleJogadorNotFound(JogadorNotFoundException ex) {
        logger.error("Erro ao encontrar jogador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(LetsClubeNotFoundException.class)
    public ResponseEntity<String> handleLetsClubeNotFound(LetsClubeNotFoundException ex) {
        logger.error("Erro ao encontrar LetsClube: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MercadoNotFoundException.class)
    public ResponseEntity<String> handleMercadoNotFound(MercadoNotFoundException ex) {
        logger.error("Erro ao encontrar mercado: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(PartidaNotFoundException.class)
    public ResponseEntity<String> handlePartidaNotFound(PartidaNotFoundException ex) {
        logger.error("Erro ao encontrar partida: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(PosicaoNotFoundException.class)
    public ResponseEntity<String> handlPosicaoNotFound(PosicaoNotFoundException ex) {
        logger.error("Erro ao encontrar posicao: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InvalidFormacaoException.class)
    public ResponseEntity<String> handleInvalidFormacaoException(InvalidFormacaoException ex) {
        logger.error("Erro ao salvar formação: ", ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Formações possui posições inválidas");
    }
}

