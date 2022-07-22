package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.EscudoRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.EscudoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/escudos")
@AllArgsConstructor
public class EscudoController {

    private final EscudoService escudoService;

    @ApiOperation(value = "Salva um Escudo")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ResponseEntity<Escudo> saveEscudo(@RequestBody @Valid EscudoRequestDTO escudoRequestDTO) {
        Escudo escudo = getEscudo(escudoRequestDTO);
        Escudo escudoSalvo = escudoService.saveEscudo(escudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(escudoSalvo);
    }

    @ApiOperation(value = "Lista todos os Escudos")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<Escudo>> findAll(){
        return ResponseEntity.ok().body(escudoService.findAll());
    }

    @ApiOperation(value = "Lista o Escudo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ResponseEntity<Escudo> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(escudoService.findByID(id));
    }

    @ApiOperation(value = "Atualiza o Escudo com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public ResponseEntity<Escudo> updateEscudo(@PathVariable ("id") Long id, @RequestBody @Valid EscudoRequestDTO escudoRequestDTO){
        Escudo escudo = getEscudo(escudoRequestDTO);
        Escudo escudoSalvo = escudoService.updateEscudo(id,escudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(escudoSalvo);
    }

    private Escudo getEscudo(EscudoRequestDTO escudoRequestDTO) {
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(escudoRequestDTO,escudo);
        return escudo;
    }


}
