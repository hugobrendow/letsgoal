package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.request.LetsClubeRequestDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.LetsClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/letsClubes")
@AllArgsConstructor
public class LetsClubeController {
    final LetsClubeService letsClubeService;

    @ApiOperation(value = "Salva um Let's Clube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public ResponseEntity<LetsClube> saveLetsClube(@RequestBody @Valid LetsClubeRequestDTO letsClubeRequestDTO) {
        LetsClube letsClube = getLetsClube(letsClubeRequestDTO);
        LetsClube letsClubeSalvo = letsClubeService.saveLetsClub(letsClube);
        return ResponseEntity.status(HttpStatus.CREATED).body(letsClubeSalvo);
    }
    @ApiOperation(value = "Lista todos os Let's Clubes")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<LetsClube>> findAll() {
        return ResponseEntity.ok().body(letsClubeService.findAll());
    }


    @ApiOperation(value = "Lista um Let's Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public ResponseEntity<LetsClube> findById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok().body(letsClubeService.findByID(id));
    }

    @ApiOperation(value = "Atualiza um Let's Clube com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public ResponseEntity<LetsClube> updateLetsClube(@PathVariable ("id") Long id,
                                                @RequestBody @Valid LetsClubeRequestDTO letsClubeRequestDTO) {

        LetsClube letsClube = getLetsClube(letsClubeRequestDTO);
        LetsClube letsClubeSalvo = letsClubeService.updateLetsClub(id,letsClube);

        return ResponseEntity.status(HttpStatus.CREATED).body(letsClubeSalvo);
    }

    private LetsClube getLetsClube(LetsClubeRequestDTO letsClubeRequestDTO) {
        LetsClube letsClube = new LetsClube();
        Formacao formacao = new Formacao();
        List<Patrocinador> patrocinadores = new ArrayList<>();
        BeanUtils.copyProperties(letsClubeRequestDTO,letsClube);
        BeanUtils.copyProperties(letsClubeRequestDTO.getFormacao(),formacao);
        BeanUtils.copyProperties(letsClubeRequestDTO.getPatrocinadores(),patrocinadores);
        letsClube.setFormacao(formacao);
        letsClube.setPatrocinadores(patrocinadores);
        return letsClube;
    }

}
