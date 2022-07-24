package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.DTO.ClubeDTO.ClubeRequestDTO;
import br.com.letscode.letsgoal.DTO.ClubeDTO.ClubeResponseDTO;
import br.com.letscode.letsgoal.model.ClassErrors.BadErrorClass;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.ClubeService;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @ApiOperation(value = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Formacao.class, responseContainer = "Lista") })
    @GetMapping
    public ResponseEntity<List<ClubeResponseDTO>> findAll(){
        var listClubes = clubeService.findAll();
        return ResponseEntity.ok(clubeService.conversorEntidadeParaDTO(listClubes));
    }

    @PostMapping
    public ResponseEntity<List<ClubeResponseDTO>> saveClube(@RequestBody @Valid ClubeRequestDTO clubeRequestDTO){
        var clube = clubeService.saveClube(clubeRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clube.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubeResponseDTO> findById(@PathVariable Long id){
        var clube = clubeService.findById(id);
        return ResponseEntity.ok(clubeService.conversorEntidadeParaDTO(clube));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubeResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ClubeRequestDTO clubeRequestDTO){
        var clubeAtualizado = clubeService.update(id, clubeRequestDTO);
        return ResponseEntity.ok(clubeService.conversorEntidadeParaDTO(clubeAtualizado));
    }
}
