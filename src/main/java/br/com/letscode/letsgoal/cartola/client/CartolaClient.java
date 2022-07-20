package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.dto.ClubeCartolaDTO;
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
public class CartolaClient {
    HttpClient httpClient = HttpClient.newHttpClient();
    private static final String URL = "https://api.cartola.globo.com";

    public String listarClubes() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/clubes"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        List<ClubeCartolaDTO> clubes = extrairClubes(node);
        return response.body();
    }

    public static List<ClubeCartolaDTO> extrairClubes(JsonNode root) {
        List<ClubeCartolaDTO> clubes = new ArrayList<>();
        if (root.isObject()) {
            extrairClube(root, clubes);
        }
        return clubes;
    }

    private static void extrairClube(JsonNode root, List<ClubeCartolaDTO> clubes) {
        Iterator<String> fieldNames = root.fieldNames();

        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode fieldValue = root.get(fieldName);
            if (fieldName.equals("id")) {
                clubes.add(new ClubeCartolaDTO(root.get("id").longValue(), root.get("nome").textValue(),
                        root.get("abreviacao").textValue(), root.get("escudos").textValue(),
                        root.get("nome_fantasia").textValue()));
            } else {
                extrairClube(fieldValue, clubes);
            }
        }
    }
}
