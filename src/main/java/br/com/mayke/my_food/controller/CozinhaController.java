package br.com.mayke.my_food.controller;

import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.exception.BadRequestException;
import br.com.mayke.my_food.service.cozinha.CozinhaService;
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
@RequestMapping(value = "/api/cozinha")
public class CozinhaController {

    @Autowired
    private CozinhaService cozinhaService;

    @PostMapping(value = "/v1/cozinha", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> createCozinha(@Valid @RequestBody Cozinha cozinhaRequest) {
        log.info("CozinhaController.createCozinha - start - Params: {}", cozinhaRequest);
        final Cozinha cozinha = cozinhaService.createCozinha(cozinhaRequest);
        log.info("CozinhaController.createCozinha - end - Response: {}", cozinha);
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
    }

    @GetMapping(value = "/v1/cozinha", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Cozinha>> findAll() {
        log.info("CozinhaController.findAll - start ");
        Set<Cozinha> cozinhas = cozinhaService.findAll();
        log.info("CozinhaController.findAll - end - Response: {}", cozinhas);
        return ResponseEntity.status(HttpStatus.OK).body(cozinhas);
    }

    @PutMapping(value = "/v1/cozinha", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> update(@Valid @RequestBody Cozinha cozinhaRequest) {
        log.info("CozinhaController.update - start - Params: {}", cozinhaRequest);
        if (isNull(cozinhaRequest.getId()))
            throw new BadRequestException("Id obrigatorio!");
        Cozinha cozinha = cozinhaService.update(cozinhaRequest);
        log.info("CozinhaController.update - end - Response: {}", cozinha);
        return ResponseEntity.status(HttpStatus.OK).body(cozinha);
    }

    @DeleteMapping(value = "/v1/cozinha/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
        log.info("CozinhaController.delete - start - Params: {}", id);
        if (isNull(id))
            throw new BadRequestException("Id obrigatorio!");
        cozinhaService.delete(id);
        log.info("CozinhaController.update - end ");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
