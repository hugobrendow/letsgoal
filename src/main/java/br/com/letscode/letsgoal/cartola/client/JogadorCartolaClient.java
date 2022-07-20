package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.dto.ClubeCartolaDTO;
import br.com.letscode.letsgoal.cartola.dto.JogadorCartolaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JogadorCartolaClient {
    HttpClient httpClient = HttpClient.newHttpClient();
    private static final String URL = "https://api.cartola.globo.com";

    public String listarJogadores() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/atletas/mercado"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        List<JogadorCartolaDTO> jogadores = new ArrayList<>();
        extrairJogador(node.get("atletas"), jogadores);
        return response.body();
    }
    private static void extrairJogador(JsonNode root, List<JogadorCartolaDTO> jogadores) {
        root.forEach(obj -> {
            jogadores.add(new JogadorCartolaDTO(
                    obj.get("atleta_id").longValue(), obj.get("clube_id").longValue(),
                    obj.get("posicao_id").longValue(), obj.get("status_id").longValue(),
                    BigDecimal.valueOf(obj.get("preco_num").longValue()),
                    obj.get("media_num").longValue(),
                    obj.get("slug").textValue(),
                    obj.get("apelido").textValue(),
                    obj.get("apelido_abreviado").textValue(),
                    obj.get("nome").textValue(),
                    obj.get("foto").textValue()
            ));
        });
    }
}
