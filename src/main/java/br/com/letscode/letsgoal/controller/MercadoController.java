package br.com.letscode.letsgoal.controller;

import br.com.letscode.letsgoal.dto.MercadoDTO;
import br.com.letscode.letsgoal.model.BadErrorClass;
import br.com.letscode.letsgoal.model.Mercado;
import br.com.letscode.letsgoal.service.MercadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mercados")
public class MercadoController {
    final MercadoService mercadoService;
    @ApiOperation(value = "Visualizar Status Mercado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = Mercado.class, responseContainer = "Lista")})

    @GetMapping("/{id}")
    public ResponseEntity<Mercado> viewStatus(@PathVariable("id") Long id) {
        Mercado mercado = mercadoService.viewStatus(id);
        return ResponseEntity.ok().body(mercado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id,
                                                 @RequestBody MercadoDTO mercadoDTO) {

        Mercado mercado = new Mercado();
        BeanUtils.copyProperties(mercadoDTO, mercado);
        Mercado mercadoAtualizado = mercadoService.changeStatus(mercado, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(mercadoAtualizado);
    }

}
