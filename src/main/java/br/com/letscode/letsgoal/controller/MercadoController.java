package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.MercadoDTOResponse;
import br.com.letscode.letsgoal.service.MercadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    private final MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @GetMapping
    public ResponseEntity<List<MercadoDTOResponse>> findAll(){
        List<MercadoDTOResponse> all = mercadoService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercadoDTOResponse> findById(@PathVariable Long id){
        MercadoDTOResponse byId = mercadoService.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
