package br.com.mayke.my_food.service.usuario;

import br.com.mayke.my_food.entities.Usuario;

import java.util.Set;

public interface UsuarioService {
    Usuario create(Usuario usuarioRequest);

    Set<Usuario> findAll();

    void delete(Long id);
}
