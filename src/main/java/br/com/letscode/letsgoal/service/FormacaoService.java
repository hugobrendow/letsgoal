package br.com.letscode.letsgoal.service;

import br.com.letscode.letsgoal.exception.FormacaoNotFoundException;
import br.com.letscode.letsgoal.exception.InvalidFormacaoException;
import br.com.letscode.letsgoal.model.Formacao;
import br.com.letscode.letsgoal.model.Posicao;
import br.com.letscode.letsgoal.repository.FormacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormacaoService {
    final FormacaoRepository formacaoRepository;

    public Formacao save(Formacao formacao) {
        //Optional<Formacao> optionalFormacao = formacaoRepository.findById(formacao.getId());
        if (!isValidFormacao(formacao)) {
            throw new InvalidFormacaoException();
        }
//        TODO VERIFICAR SE PODE SALVAR FORMAÇÕES REPETIDAS
//        optionalFormacao.ifPresent(obj -> {
//            throw new ClienteExistenteException();
//        });
        return formacaoRepository.save(formacao);
    }

    private boolean isValidFormacao(Formacao formacao) {
        long contTecnico = formacao.getPosicoes().stream()
                .filter(posicao -> isPosicaoTecnico("tec", posicao)).count();

        long contGoleiro = formacao.getPosicoes().stream()
                .filter(posicao -> isPosicaoTecnico("gol", posicao)).count();

        long contJogadores = formacao.getPosicoes().stream()
                .filter(posicao -> !isPosicaoTecnico("tec", posicao) &&
                        !isPosicaoTecnico("gol", posicao)).count();


        return contTecnico == 1 && contGoleiro == 1 && contJogadores == 10;
    }

    private boolean isPosicaoTecnico(String abreviacao, Posicao posicao) {
        return abreviacao.equals(posicao.getAbreviacao());
    }

    public List<Formacao> findAll() {
        return formacaoRepository.findAll();
    }

    public Formacao findById(Long id) {
        return formacaoRepository
                .findById(id)
                .orElseThrow(FormacaoNotFoundException::new);
    }
}
