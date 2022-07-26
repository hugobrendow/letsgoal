package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.Dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.EscudoCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.FormacaoCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.JogadorCartolaDTO;
import br.com.letscode.letsgoal.service.PosicaoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class FormacaoCartolaClient {

    @Autowired
    PosicaoService posicaoService;

    private static final String URL = "https://api.cartola.globo.com";

    public List<FormacaoCartolaDTO> listarFormacoes() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest uri = HttpRequest.newBuilder()
                .uri(URI.create(URL.concat("/esquemas")))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();
        HttpResponse<String> resposta = httpClient.send(uri, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(resposta.body());
        return extrairFormacao(jsonNode);

    }


    private List<FormacaoCartolaDTO> extrairFormacao(JsonNode jsonNode) {
        var posicoes = posicaoService.findAll();
        List<FormacaoCartolaDTO> formacao = new ArrayList<>();
        jsonNode.forEach(obj -> {
            var mapa = new HashMap<String, Long>();
            mapa.put(obj.get("posicoes").fieldNames().next(), obj.get("posicoes").get().getAbreviacao()).longValue());
            formacao.add(new FormacaoCartolaDTO(
                    obj.get("esquema_id").longValue(),
                    obj.get("nome").textValue(),
                    mapa));



        });
        return formacao;

    }
}
