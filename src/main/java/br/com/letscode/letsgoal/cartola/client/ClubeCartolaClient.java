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

    private static final String URL = "https://api.cartola.globo.com"; //escopo da requisicao

    public List<ClubeCartolaDTO> listarClubes() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient(); //Responsável por faazer a conexão
        HttpRequest uri = HttpRequest
                .newBuilder()
                .uri(URI.create(URL.concat("/clubes")))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build(); //Requisicao para o servico

        HttpResponse<String> resposta = httpClient.send(uri, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(resposta.body());

        return extrairClubes(jsonNode);
    }

    //Recursividade
    public List<ClubeCartolaDTO> extrairClubes(JsonNode jsonNode) {
        List<ClubeCartolaDTO> clubes = new ArrayList<>();
        if (jsonNode.isObject()) {
            extrairClube(jsonNode, clubes);
        }
        return clubes;
    }

    public void extrairClube(JsonNode jsonNode, List<ClubeCartolaDTO> clubes) {
        Iterator<String> fieldNames = jsonNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = jsonNode.fieldNames().next();
            JsonNode field = jsonNode.get(fieldName); //pegar os objetos
            //Começar a fazer o mapeamento
            if (!field.get("id").isNull()) {
                EscudoCartolaDTO escudos = new EscudoCartolaDTO(
                        field.get("escudos").get("60x60").textValue(),
                        field.get("escudos").get("45x45").textValue(),
                        field.get("escudos").get("30x30").textValue()
                );

                clubes.add(new ClubeCartolaDTO(
                        field.get("id").longValue(),
                        field.get("nome").textValue(),
                        field.get("abreviacao").textValue(),
                        field.get("nome_fantasia").textValue(),
                        escudos
                ));
            } else {
                extrairClube(field, clubes);
            }
        }
    }
}
