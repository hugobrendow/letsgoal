package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoRequestDTO;
import br.com.letscode.letsgoal.DTO.FormacaoDTO.FormacaoResponseDTO;
import br.com.letscode.letsgoal.model.ClassErrors.BadErrorClass;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.service.FormacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {

    private final FormacaoService formacaoService;


    public FormacaoController(FormacaoService formacaoService, ModelMapper modelMapper) {
        this.formacaoService = formacaoService;
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
    public ResponseEntity<List<FormacaoResponseDTO>> findAll() {
        var listFormacao = formacaoService.findAll();
        return ResponseEntity.ok(formacaoService.conversorEntidadeParaDTO(listFormacao));
    }

    @PostMapping
    public ResponseEntity<Void>  saveFormacao(@RequestBody @Valid FormacaoRequestDTO formacaoRequestDTO) {
        var formacao = formacaoService.saveFormacao(formacaoRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(formacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoResponseDTO> findById(@PathVariable Long id) {
        var formacao = formacaoService.findById(id);
        return ResponseEntity.ok(formacaoService.conversorEntidadeParaDTO(formacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormacaoResponseDTO> save(@PathVariable Long id, @RequestBody @Valid FormacaoRequestDTO formacaoRequestDTO){
        var formacao = formacaoService.atualizar(id, formacaoRequestDTO);
        return ResponseEntity.ok(formacaoService.conversorEntidadeParaDTO(formacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        formacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
