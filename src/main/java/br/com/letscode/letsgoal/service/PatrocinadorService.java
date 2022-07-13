package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.model.Patrocinador;
import br.com.letscode.letsgoal.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {

   @Autowired
   private PatrocinadorRepository repository;

   public List<Patrocinador> findAll(){
       return repository.findAll();
   }

   public Optional<Patrocinador> findById(Long id){
       return repository.findById(id);
   }

   public Patrocinador save(Patrocinador patrocinador){
       return repository.save(patrocinador);
   }

   public Patrocinador update(Long id, Patrocinador patrocinador){
       Optional<Patrocinador> patrocinadorOptional = repository.findById(id);
       if (patrocinadorOptional.isEmpty()){
           throw new RuntimeException();
       }
       return save(patrocinador);
   }
}
