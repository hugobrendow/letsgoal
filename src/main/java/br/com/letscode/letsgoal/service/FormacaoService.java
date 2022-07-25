package br.com.letscode.letsgoal.service;


import br.com.letscode.letsgoal.exception.FormacaoBadRequestException;
import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.model.Clube;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@AllArgsConstructor
public class FormacaoService {

    final FormacaoRepository formacaoRepository;

    public Formacao saveFormacao(Formacao formacao){
        int goleiroCount = 0;
        int tecnicoCount = 0;
            for(Posicao p : formacao.getPosicoes()){
                if(p.getNome().equals("GOLEIRO")){
                    goleiroCount++;
                }
                if (p.getNome().equals("TÉCNICO")) {
                    tecnicoCount++;
                }
            }
        if(formacao.getPosicoes().size() == 12 && goleiroCount ==1 && tecnicoCount == 1) {
            return formacaoRepository.save(formacao);
        }
        else {
            throw new FormacaoBadRequestException();
        }
    }

    public List<Formacao> salvarFormacoes(List<Formacao> formacoes) {
        return formacaoRepository.saveAll(formacoes);
    }

    public List<Formacao> listar(){
        return (List<Formacao>) formacaoRepository.findAll();
    }

    public Formacao findById(Long id){
        Formacao formacao = formacaoRepository
                .findById(id)
                .orElseThrow(() -> new FormacaoNotFoundException());
        return formacao;
    }

}
