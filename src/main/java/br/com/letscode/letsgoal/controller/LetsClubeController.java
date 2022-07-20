package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.LetsClubeDTOResponse;
import br.com.letscode.letsgoal.service.LetsClubeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letsclubes")
public class LetsClubeController {

    private final LetsClubeService letsClubeService;

    public LetsClubeController(LetsClubeService letsClubeService) {
        this.letsClubeService = letsClubeService;
    }

    @GetMapping
    public ResponseEntity<List<LetsClubeDTOResponse>> findAll(){
        List<LetsClubeDTOResponse> all = letsClubeService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetsClubeDTOResponse> findById(@PathVariable Long id){
        LetsClubeDTOResponse byId = letsClubeService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

//    @PostMapping
//    public LetsClube saveLetsCLube(@RequestBody LetsClube letsclube) {
//        return letsclube;
//    }
//
//
//    @PutMapping("/{id}")
//    public LetsClube updateLetsClube(@PathVariable Long id,
//                                           @RequestBody LetsClube letsClube) {
//        return letsClube;
//    }
}
