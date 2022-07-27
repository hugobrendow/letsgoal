package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.EscudoCartolaDTO;
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

    private static final String URL = "https://api.cartola.globo.com";

    public List<ClubeCartolaDTO> listarClubes() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/clubes"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        return extrairClubes(jsonNode);
    }

    public List<ClubeCartolaDTO> extrairClubes(JsonNode jsonNode) {
        List<ClubeCartolaDTO> clubes = new ArrayList<>();
        if (jsonNode.isObject()) {
            extrairClube(jsonNode, clubes);
        }
        return clubes;
    }

    private void extrairClube(JsonNode jsonNode, List<ClubeCartolaDTO> clubes) {
        Iterator<String> fieldNames = jsonNode.fieldNames();
        while(fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode field = jsonNode.get(fieldName);
            if (fieldName.equals("id")) {
                EscudoCartolaDTO escudo = new EscudoCartolaDTO(jsonNode.get("escudos").get("60x60").textValue(), jsonNode.get("escudos").get("45x45").textValue(), jsonNode.get("escudos").get("30x30").textValue());
                clubes.add(new ClubeCartolaDTO(jsonNode.get("id").longValue(),
                        jsonNode.get("nome").textValue(),
                        jsonNode.get("abreviacao").textValue(),
                        jsonNode.get("nome_fantasia").textValue(),
                        escudo));
            } else {
                extrairClube(field, clubes);
            }
        }
    }
}
