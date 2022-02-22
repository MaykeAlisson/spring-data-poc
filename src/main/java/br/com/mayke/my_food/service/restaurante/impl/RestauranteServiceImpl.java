package br.com.mayke.my_food.service.restaurante.impl;

import br.com.mayke.my_food.dto.RestauranteRequestDto;
import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.entities.Restaurante;
import br.com.mayke.my_food.exception.NotFoundException;
import br.com.mayke.my_food.repository.cozinha.CozinhaRepository;
import br.com.mayke.my_food.repository.restaurante.RestauranteRepository;
import br.com.mayke.my_food.service.restaurante.RestauranteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Slf4j
@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public Restaurante createRestaurante(final RestauranteRequestDto request){
        log.info("RestauranteServiceImpl.createRestaurante - start - RestauranteRequestDto: {}", request);
        Long idCozinha = request.getIdCozinha();
        final Cozinha cozinha = cozinhaRepository.findById(idCozinha)
                .orElseThrow(() -> new NotFoundException(format("Conzinha com o id %s não encontrado", idCozinha)));

        Restaurante restaurante = Restaurante.builder()
                .nome(request.getNome())
                .taxaFrete(request.getTaxaFrete())
                .cozinha(cozinha)
                .build();

        return restauranteRepository.save(restaurante);
    }

    @Override
    public Set<Restaurante> findAll() {
        log.info("RestauranteServiceImpl.findAll - start ");
        return new HashSet<>(restauranteRepository.findAll());
    }

    @Override
    public Restaurante update(Restaurante restauranteRequest) {
        log.info("RestauranteServiceImpl.update - start - Restaurante: {}", restauranteRequest);
        return restauranteRepository.save(restauranteRequest);
    }

    @Override
    public void delete(Long id) {
        log.info("RestauranteServiceImpl.delete - start - Id: {}", id);
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Conzinha com o id %s não encontrada!", id)));
        restauranteRepository.delete(restaurante);
    }
}
