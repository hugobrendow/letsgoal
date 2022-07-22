package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.PatrocinadorRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
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
@RequestMapping("/patrocinadores")
@AllArgsConstructor
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;


    @ApiOperation(value = "Salva um Patrocinador")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ResponseEntity<Patrocinador> savePatrocinador(@RequestBody @Valid PatrocinadorRequestDTO patrocinadorRequestDTO) {
        Patrocinador patrocinador = getPatrocinador(patrocinadorRequestDTO);
        Patrocinador patrocinadorSalvo = patrocinadorService.savePatrocinador(patrocinador);
        return ResponseEntity.status(HttpStatus.CREATED).body(patrocinadorSalvo);
    }


    @ApiOperation(value = "Lista todos os Patrocinadores")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<Patrocinador>> findAll() {
        return ResponseEntity.ok().body(patrocinadorService.findAll());
    }

    @ApiOperation(value = "Lista um Patrocinador com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ResponseEntity<Patrocinador> findById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok().body(patrocinadorService.findById(id));
    }
    @ApiOperation(value = "Atualiza um Patrocinador com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public ResponseEntity<Patrocinador> updatePatrocinador(@PathVariable ("id") Long id,
                                                      @RequestBody @Valid PatrocinadorRequestDTO patrocinadorRequestDTO) {
        Patrocinador patrocinador = getPatrocinador(patrocinadorRequestDTO);
        Patrocinador patrocinadorSalvo = patrocinadorService.updatePatrocinador(id,patrocinador);

        return ResponseEntity.status(HttpStatus.CREATED).body(patrocinadorSalvo);
    }
    private Patrocinador getPatrocinador(PatrocinadorRequestDTO patrocinadorRequestDTO) {
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(patrocinadorRequestDTO,patrocinador);
        return patrocinador;
    }

}
