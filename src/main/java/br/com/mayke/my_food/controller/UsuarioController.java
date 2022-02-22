package br.com.mayke.my_food.controller;

import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.entities.Usuario;
import br.com.mayke.my_food.exception.BadRequestException;
import br.com.mayke.my_food.service.usuario.UsuarioService;
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
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/v1/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuarioRequest){
        log.info("UsuarioController.create - start - Params: {}", usuarioRequest);
        final Usuario user = usuarioService.create(usuarioRequest);
        log.info("UsuarioController.create - end - Response: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(value = "/v1/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Usuario>> findAll(){
        log.info("UsuarioController.create - start");
        final Set<Usuario> usuarios = usuarioService.findAll();
        log.info("UsuarioController.create - end - Response: {}", usuarios);
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @DeleteMapping(value = "/v1/usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("UsuarioController.delete - start - Params: {}", id);
        if (isNull(id))
            throw new BadRequestException("Id obrigatorio!");
        usuarioService.delete(id);
        log.info("UsuarioController.delete - end ");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
