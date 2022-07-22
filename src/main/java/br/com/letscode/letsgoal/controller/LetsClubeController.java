package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.LetsClubeDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.LetsClube;
import br.com.letscode.letsgoal.service.LetsClubeService;
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
@RequestMapping("/letsClubes")
public class LetsClubeController {

    final LetsClubeService letsClubeService;

    @ApiOperation(value = "Salvar LetsClube")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = LetsClube.class, responseContainer = "Lista")})

    @GetMapping
    public ResponseEntity<List<LetsClube>> findAll() {
        return ResponseEntity.ok().body(letsClubeService.findAll());
    }
    @PostMapping
    public ResponseEntity<LetsClube> saveLetsClube(@RequestBody @Valid LetsClubeDTO letsClubeDTO) {
        LetsClube letsClube = new LetsClube();
        BeanUtils.copyProperties(letsClubeDTO, letsClube);
        LetsClube letsClubeSalvo = letsClubeService.save(letsClube);
        return ResponseEntity.status(HttpStatus.CREATED).body(letsClubeSalvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LetsClube> update(@PathVariable Long id, @Valid @RequestBody LetsClubeDTO letsClubeDTO) {
        LetsClube letsClube = new LetsClube();
        BeanUtils.copyProperties(letsClubeDTO, letsClube);
        LetsClube letsClubeSalvo = letsClubeService.update(letsClube, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(letsClubeSalvo);

    }
    @GetMapping("/{id}")
    public ResponseEntity<LetsClube> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(letsClubeService.findById(id));
    }


}
