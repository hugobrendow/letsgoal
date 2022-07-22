package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.ClubeRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.ClubeService;
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
@RequestMapping("/clubes")
@AllArgsConstructor
public class ClubeController {
    private final ClubeService clubeService;

    @ApiOperation(value = "Salva um Clube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ResponseEntity<Clube> saveClube(@RequestBody @Valid ClubeRequestDTO clubeRequestDTO){
        Clube clube = getClube(clubeRequestDTO);
        Clube clubeSalvo = clubeService.saveClube(clube);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo); }

    @ApiOperation(value = "Lista todos os Clubes")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })@GetMapping
    public ResponseEntity<List<Clube>> findAll(){
        return ResponseEntity.ok().body(clubeService.findAll());
    }

    @ApiOperation(value = "Lista o Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ResponseEntity<Clube> findById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(clubeService.findById(id));
    }
    @ApiOperation(value = "Atualiza o Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })@PutMapping("/{id}")
    public ResponseEntity<Clube> updateClube(@PathVariable ("id") Long id, @RequestBody @Valid ClubeRequestDTO clubeRequestDTO){
        Clube clube = getClube(clubeRequestDTO);
        Clube clubeSalvo = clubeService.updateClube(id, clube);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }
    private Clube getClube(ClubeRequestDTO clubeRequestDTO) {
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeRequestDTO,clube);
        BeanUtils.copyProperties(clubeRequestDTO.getEscudo(),escudo);
        clube.setEscudos(escudo);
        return clube;
    }
}
