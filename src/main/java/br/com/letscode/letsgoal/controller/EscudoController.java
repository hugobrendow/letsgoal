package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.EscudoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Escudo;
import br.com.letscode.letsgoal.service.EscudoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/escudos")
public class EscudoController {
    final EscudoService escudoService;


    @ApiOperation(value = "Salvar Escudo")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Escudo.class, responseContainer = "Lista")})
    @GetMapping
    public ResponseEntity<List<Escudo>> findAll() {
        return ResponseEntity.ok().body(escudoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Escudo> save(@RequestBody @Valid EscudoDTO escudoDTO) {
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(escudoDTO, escudo);
        Escudo escudoSalvo=  escudoService.save(escudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(escudoSalvo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Escudo> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(escudoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escudo> update(@PathVariable("id") Long id, @RequestBody @Valid EscudoDTO escudoDTO) {
        Escudo escudo = new Escudo();
        BeanUtils.copyProperties(escudoDTO, escudo);
        Escudo escudoSalvo = escudoService.update(escudo, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(escudoSalvo);
    }
}
