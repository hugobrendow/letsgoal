package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.Dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.Dto.EscudoCartolaDTO;
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
public class ClubeCartolaClient {

    private static final String URL="https://api.cartola.globo.com";

    public List<ClubeCartolaDTO> listarClubes() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest uri = HttpRequest.newBuilder()
                .uri(URI.create(URL.concat("/clubes")))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();
        HttpResponse<String> resposta = httpClient.send(uri, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(resposta.body());
        return extrairClubes(jsonNode);

    }

    private List<ClubeCartolaDTO> extrairClubes(JsonNode jsonNode) {
        List<ClubeCartolaDTO> clubeCartolaDTOS = new ArrayList<>();
        if(jsonNode.isObject()){
            extrairClube(jsonNode, clubeCartolaDTOS);
        }
        return clubeCartolaDTOS;
    }

    private void extrairClube(JsonNode jsonNode, List<ClubeCartolaDTO> clubeCartolaDTOS) {
        Iterator<String> fieldNames = jsonNode.fieldNames();
        while (fieldNames.hasNext()){
            String fieldName = fieldNames.next();
            JsonNode field = jsonNode.get(fieldName);
            if(fieldName.equals("id")){
                EscudoCartolaDTO escudo = new EscudoCartolaDTO(jsonNode.get("escudos").get("60x60").textValue(),
                        jsonNode.get("escudos").get("45x45").textValue(),
                        jsonNode.get("escudos").get("30x30").textValue());
                clubeCartolaDTOS.add(new ClubeCartolaDTO(jsonNode.get("id").longValue(),
                        jsonNode.get("nome").textValue(),
                        jsonNode.get("abreviacao").textValue(),
                        jsonNode.get("nome_fantasia").textValue(),
                        escudo));
            }else{
                extrairClube(field, clubeCartolaDTOS);
            }

        }
    }
}
