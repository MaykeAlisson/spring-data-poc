package br.com.mayke.my_food.controller;

import br.com.mayke.my_food.dto.PedidoRequestDto;
import br.com.mayke.my_food.entities.Pedido;
import br.com.mayke.my_food.service.pedido.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/v1/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> create(@Valid @RequestBody PedidoRequestDto pedidoRequest) {
        log.info("PedidoController.create - start - Params: {}", pedidoRequest);
        final Pedido pedido = pedidoService.create(pedidoRequest);
        log.info("PedidoController.create - end - Response: {}", pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping(value = "/v1/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> findByUser(@RequestParam Long idUser){
        final List<Pedido> pedidos = pedidoService.findByUser(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping(value = "/v1/pedido/cozinha/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> findByCozinha(@PathVariable Long id){
        final List<Pedido> pedidos = pedidoService.findByCozinha(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping(value = "/v1/pedido/restaurante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> findByRestaurante(@PathVariable Long id){
        final List<Pedido> pedidos = pedidoService.findByRestaurante(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

}
