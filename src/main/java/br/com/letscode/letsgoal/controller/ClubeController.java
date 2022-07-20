package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.ClubeDTOResponse;
import br.com.letscode.letsgoal.service.ClubeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @GetMapping
    public ResponseEntity<List<ClubeDTOResponse>> findAll(){
        List<ClubeDTOResponse> all = clubeService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubeDTOResponse> findById(@PathVariable Long id){
        ClubeDTOResponse byId = clubeService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

}
