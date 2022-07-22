package br.com.letscode.letsgoal.exception;

import br.com.letscode.letsgoal.controller.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerImpl {
    private Logger loggerPatrocinador = LoggerFactory.getLogger(PatrocinadorController.class);
    private Logger loggerFormacao = LoggerFactory.getLogger(FormacaoController.class);
    private Logger loggerClube= LoggerFactory.getLogger(ClubeController.class);
    private Logger loggerEscudo = LoggerFactory.getLogger(EscudoController.class);
    private Logger loggerJogador = LoggerFactory.getLogger(JogadorController.class);
    private Logger loggerLetsClube = LoggerFactory.getLogger(LetsClubeController.class);
    private Logger loggerPosicao = LoggerFactory.getLogger(PosicaoController.class);


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(DataIntegrityViolationException ex) {
        log.error("Erro ao processar request: ", ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body("Informação inválida, verifique seus dados");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("Erro ao processar request: ", ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(PatrocinadorNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(PatrocinadorNotFoundException ex) {
        loggerPatrocinador.error("Erro ao encontrar patrocinador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(FormacaoNotFoundException.class)
    public ResponseEntity<String> handlePatrocinadorNotFound(FormacaoNotFoundException ex) {
        loggerFormacao.error("Erro ao encontrar formação: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(PosicaoNotFoundException.class)
    public ResponseEntity<String> handlePosicaoNotFound(PosicaoNotFoundException ex) {
        loggerPosicao.error("Erro ao encontrar posição: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(LetsClubeNotFoundException.class)
    public ResponseEntity<String> handleLetsClubeNotFound(LetsClubeNotFoundException ex) {
        loggerLetsClube.error("Erro ao encontrar Let's Clube: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EscudoNotFoundException.class)
    public ResponseEntity<String> handleEscudoNotFound(EscudoNotFoundException ex) {
        loggerEscudo.error("Erro ao encontrar Escudo: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(JogadorNotFoundException.class)
    public ResponseEntity<String> handleJogadorNotFound(JogadorNotFoundException ex) {
        loggerJogador.error("Erro ao encontrar Jogador: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(ClubeNotFoundException.class)
    public ResponseEntity<String> handleClubeNotFound(ClubeNotFoundException ex) {
        loggerClube.error("Erro ao encontrar Clube: ", ex.getLocalizedMessage());
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(DadoExistenteException.class)
    public ResponseEntity<String> handleDadoExistenteException(DadoExistenteException ex) {
        loggerClube.error("Erro ao salvar clube: ", ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Clube com nome ou abreviação existente. Tente novamente.");
    }
}
