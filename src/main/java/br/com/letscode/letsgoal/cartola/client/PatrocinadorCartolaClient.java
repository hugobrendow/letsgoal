package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.dto.PatrocinadorCartolaDTO;
import br.com.letscode.letsgoal.domain.models.Patrocinador;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatrocinadorCartolaClient {

    private static final String URL = "https://api.cartola.globo.com";

    public List<PatrocinadorCartolaDTO> listarPatrocinadores() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/patrocinadores"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        return extrairPatrocinadores(node);
    }

    private List<PatrocinadorCartolaDTO> extrairPatrocinadores(JsonNode node) {
        List<PatrocinadorCartolaDTO> patrocinadorCartolaDTOS = new ArrayList<>();

        node.forEach( obj ->
                patrocinadorCartolaDTOS.add(
                        new PatrocinadorCartolaDTO(
                                obj.get("liga_id").longValue(),
                                obj.get("nome").textValue(),
                                obj.get("descricao").textValue(),
                                obj.get("url_link").textValue(),
                                obj.get("img_marca_patrocinador").textValue()
                        )
                )
        );

        return patrocinadorCartolaDTOS;
    }
}
