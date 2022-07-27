package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.dto.FormacaoCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.PosicaoCartolaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FormacaoCartolaClient {

    private static final String URL = "https://api.cartola.globo.com";

    public List<FormacaoCartolaDTO> listarFormacao() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL+"/esquemas"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        return extrairFormacao(node);
    }

    private List<FormacaoCartolaDTO> extrairFormacao(JsonNode node) {
        List<FormacaoCartolaDTO> formacaoCartolaDTOS = new ArrayList<>();

        node.forEach(obj ->
                formacaoCartolaDTOS.add(
                        new FormacaoCartolaDTO(
                                obj.get("esquema_id").longValue(),
                                obj.get("nome").textValue(),
                                extrairPosicoes(obj)
                        )
                ));

        return formacaoCartolaDTOS;
    }

    private List<PosicaoCartolaDTO> extrairPosicoes(JsonNode node){
        List<PosicaoCartolaDTO> posicaoCartolaDTOS = new ArrayList<>();

        List<JsonNode> posicoes = node.findValues("posicoes");
        posicoes.forEach(obj -> {
            Iterator<String> fieldNames = obj.fieldNames();
            while (fieldNames.hasNext()){
                String fieldName = fieldNames.next();
                long value = obj.get(fieldName).longValue();
                posicaoCartolaDTOS.add(new PosicaoCartolaDTO(fieldName, value));
            }
        });

        return posicaoCartolaDTOS;
    }
}
