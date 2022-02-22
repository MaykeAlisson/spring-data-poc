package br.com.mayke.my_food.service.usuario.impl;

import br.com.mayke.my_food.entities.Usuario;
import br.com.mayke.my_food.exception.NotFoundException;
import br.com.mayke.my_food.repository.usuario.UsuarioRepository;
import br.com.mayke.my_food.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuarioRequest) {
        return usuarioRepository.save(usuarioRequest);
    }

    @Override
    public Set<Usuario> findAll() {
        return new HashSet<>(usuarioRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Usuario com id %s não encontrado", id)));
        usuarioRepository.delete(usuario);
    }
}
