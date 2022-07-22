package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.ClubeDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.service.ClubeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    private ClubeService clubeService;
    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }
    @ApiOperation(value = "Salvar Clube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Inserção bem-sucedida",
                    response = Clube.class, responseContainer = "Clube")})
    @PostMapping
    public ResponseEntity<Clube> save(@RequestBody @Valid ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clube);
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.save(clube);

//        ClubeDTO clubeResponse = new ClubeDTO();
//        EscudoDTO escudoResponse = new EscudoDTO();
//        BeanUtils.copyProperties(clubeSalvo, clubeResponse);
//        BeanUtils.copyProperties(clubeSalvo.getEscudo(), escudoResponse);
//        clubeResponse.setEscudo(escudoResponse);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clubeResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clube> update(@PathVariable("id") Long id, @RequestBody @Valid ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(clubeDTO, clube);
        BeanUtils.copyProperties(clubeDTO.getEscudo(), escudo);
        clube.setEscudo(escudo);
        Clube clubeSalvo = clubeService.update(clube, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clube> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(clubeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Clube>> listClube() {
        return ResponseEntity.ok().body(clubeService.findAll());
    }
}
