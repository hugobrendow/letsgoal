package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.PatrocinadorDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.service.PatrocinadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
@AllArgsConstructor
public class PatrocinadorController {
    private PatrocinadorService patrocinadorService;

    @ApiOperation(value = "Lista todos os Patrocinadores")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public List<PatrocinadorDTO> findAll() {
        List<PatrocinadorDTO> patrocinadoresDTO = new ArrayList<>();
        patrocinadorService.findAll()
                .forEach(patrocinador -> {patrocinadoresDTO.add(new PatrocinadorDTO(patrocinador));});
        return patrocinadoresDTO;
    }

    @ApiOperation(value = "Salva um Patrocinador")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @PostMapping
    public PatrocinadorDTO savePatrocinador(@RequestBody Patrocinador patrocinador) {
        return new PatrocinadorDTO(patrocinadorService.savePatrocinador(patrocinador));
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
    public PatrocinadorDTO findById(@PathVariable Long id) {
        return new PatrocinadorDTO(patrocinadorService.findById(id));
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
    public PatrocinadorDTO updatePatrocinador(@PathVariable Long id,
                                           @RequestBody Patrocinador patrocinador) {
        return new PatrocinadorDTO(patrocinadorService.updatePatrocinador(id,patrocinador));
    }

}
