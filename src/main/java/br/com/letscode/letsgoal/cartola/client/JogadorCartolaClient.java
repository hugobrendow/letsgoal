package br.com.letscode.letsgoal.cartola.client;

import br.com.letscode.letsgoal.cartola.Dto.JogadorCartolaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JogadorCartolaClient {
    private static final String URL = "https://api.cartola.globo.com";

    public List<JogadorCartolaDTO> listarJogadores() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/atletas/mercado"))
                .header("User-Agent", "PostmanRuntime/7.26.2")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        return extrairJogador(node.get("atletas"));
    }

    private static List<JogadorCartolaDTO> extrairJogador(JsonNode root) {
        List<JogadorCartolaDTO> jogadores = new ArrayList<>();
        root.forEach(obj -> {
            jogadores.add(new JogadorCartolaDTO(
                    obj.get("atleta_id").longValue(), obj.get("clube_id").longValue(),
                    obj.get("posicao_id").longValue(), obj.get("status_id").longValue(),
                    BigDecimal.valueOf(obj.get("preco_num").longValue()),
                    obj.get("media_num").doubleValue(),
                    obj.get("slug").textValue(),
                    obj.get("apelido").textValue(),
                    obj.get("apelido_abreviado").textValue(),
                    obj.get("nome").textValue(),
                    obj.get("foto").textValue()
            ));
        });
        return jogadores;
    }

}
