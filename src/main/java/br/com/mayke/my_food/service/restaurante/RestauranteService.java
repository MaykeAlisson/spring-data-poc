package br.com.mayke.my_food.service.restaurante;

import br.com.mayke.my_food.dto.RestauranteRequestDto;
import br.com.mayke.my_food.entities.Restaurante;

import java.util.Set;

public interface RestauranteService {
    Restaurante createRestaurante(RestauranteRequestDto request);

    Set<Restaurante> findAll();

    Restaurante update(Restaurante restauranteRequest);

    void delete(Long id);
}
