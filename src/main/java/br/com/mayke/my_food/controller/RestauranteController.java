package br.com.mayke.my_food.controller;

import br.com.mayke.my_food.dto.RestauranteRequestDto;
import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.entities.Restaurante;
import br.com.mayke.my_food.exception.BadRequestException;
import br.com.mayke.my_food.service.restaurante.RestauranteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping(value = "/api/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping(value = "/v1/restaurante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurante> createRestaurante(@Valid @RequestBody RestauranteRequestDto restauranteRequest) {
        log.info("RestauranteController.createRestaurante - start - Params: {}", restauranteRequest);
        Restaurante restaurante = restauranteService.createRestaurante(restauranteRequest);
        log.info("RestauranteController.createRestaurante - end - Response: {}", restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    }

    @GetMapping(value = "/v1/restaurante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Restaurante>> findAll() {
        log.info("RestauranteController.findAll - start ");
        Set<Restaurante> restaurantes = restauranteService.findAll();
        log.info("RestauranteController.findAll - end - Response: {}", restaurantes);
        return ResponseEntity.status(HttpStatus.OK).body(restaurantes);
    }

    @PutMapping(value = "/v1/restaurante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurante> update(@Valid @RequestBody Restaurante restauranteRequest) {
        log.info("RestauranteController.update - start - Params: {}", restauranteRequest);
        if (isNull(restauranteRequest.getId()))
            throw new BadRequestException("Id obrigatorio!");
        Restaurante restaurante = restauranteService.update(restauranteRequest);
        log.info("RestauranteController.update - end - Response: {}", restaurante);
        return ResponseEntity.status(HttpStatus.OK).body(restaurante);
    }

    @DeleteMapping(value = "/v1/restaurante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurante> delete(@PathVariable Long id) {
        log.info("RestauranteController.delete - start - Params: {}", id);
        if (isNull(id))
            throw new BadRequestException("Id obrigatorio!");
        restauranteService.delete(id);
        log.info("RestauranteController.update - end ");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
