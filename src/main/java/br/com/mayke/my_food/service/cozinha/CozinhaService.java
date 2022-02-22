package br.com.mayke.my_food.service.cozinha;

import br.com.mayke.my_food.entities.Cozinha;

import java.util.Set;

public interface CozinhaService {
    Cozinha createCozinha(Cozinha cozinha);

    Set<Cozinha> findAll();

    Cozinha update(Cozinha cozinha);

    void delete(Long id);
}
