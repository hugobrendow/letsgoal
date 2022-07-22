package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PatrocinadorDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    final PatrocinadorService patrocinadorService;

    @ApiOperation(value = "Salvar Patrocinador")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Patrocinador.class, responseContainer = "Lista")})
    @GetMapping
    public ResponseEntity<List<Patrocinador>> findAll() {
        return ResponseEntity.ok().body(patrocinadorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Patrocinador> savePatrocinador(@RequestBody PatrocinadorDTO patrocinadorDTO) {
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(patrocinadorDTO, patrocinador);
        Patrocinador patrocinadorSalvo = patrocinadorService.save(patrocinador);
        return ResponseEntity.status(HttpStatus.CREATED).body(patrocinadorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrocinador> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(patrocinadorService.findById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrocinador> updatePatrocinador(@PathVariable Long id,
                                                           @RequestBody PatrocinadorDTO patrocinadorDTO) {
        Patrocinador patrocinador = new Patrocinador();
        BeanUtils.copyProperties(patrocinadorDTO, patrocinador);
        Patrocinador patrocinadorSalvo = patrocinadorService.update(patrocinador, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(patrocinadorSalvo);
    }

}
