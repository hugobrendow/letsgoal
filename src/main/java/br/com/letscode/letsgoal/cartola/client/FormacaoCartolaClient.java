package br.com.letscode.letsgoal.cartola.client;


import br.com.letscode.letsgoal.cartola.dto.FormacaoCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.PosicaoCartolaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class FormacaoCartolaClient {

    private static final String URL = "https://api.cartola.globo.com";

    public List<FormacaoCartolaDTO> listarFormacoes() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest uri = HttpRequest.newBuilder()
                .uri(URI.create(URL.concat("/esquemas")))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();

        HttpResponse<String> resposta = httpClient.send(uri, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(resposta.body());
        return extrairFormacoes(jsonNode);
    }

    public List<FormacaoCartolaDTO> extrairFormacoes(JsonNode jsonNode) {
        List<FormacaoCartolaDTO> formacoes = new ArrayList<>();
        if (jsonNode.isObject()) {
            extrairFormacao(jsonNode, formacoes);
        }
        return formacoes;
    }

    private void extrairFormacao(JsonNode jsonNode, List<FormacaoCartolaDTO> formacoes) {
        Iterator<String> fieldNames = jsonNode.fieldNames();
        while(fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode field = jsonNode.get(fieldName);
            if (fieldName.equals("id")) {
                PosicaoCartolaDTO posicoes = new PosicaoCartolaDTO(jsonNode.get("posicoes").textValue());
                formacoes.add(new FormacaoCartolaDTO(jsonNode.get("id").longValue(),
                        jsonNode.get("nome").textValue(),
                        Arrays.asList(posicoes)));
            } else {
                extrairFormacao(field, formacoes);
            }
        }
    }
}
