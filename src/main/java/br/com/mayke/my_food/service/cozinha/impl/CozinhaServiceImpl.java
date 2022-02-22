package br.com.mayke.my_food.service.cozinha.impl;

import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.exception.NotFoundException;
import br.com.mayke.my_food.repository.cozinha.CozinhaRepository;
import br.com.mayke.my_food.service.cozinha.CozinhaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Slf4j
@Service
public class CozinhaServiceImpl implements CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Override
    public Cozinha createCozinha(final Cozinha cozinha) {
        log.info("CozinhaServiceImpl.createCozinha - start - Cozinha: {}", cozinha);
        return cozinhaRepository.save(cozinha);
    }

    @Override
    public Set<Cozinha> findAll() {
        log.info("CozinhaServiceImpl.findAll - start ");
        return new HashSet<>(cozinhaRepository.findAll());
    }

    @Override
    public Cozinha update(Cozinha cozinha) {
        log.info("CozinhaServiceImpl.update - start - Cozinha: {}", cozinha);
        return cozinhaRepository.save(cozinha);
    }

    @Override
    public void delete(Long id) {
        log.info("CozinhaServiceImpl.delete - start - Id: {}", id);
        Cozinha cozinha = cozinhaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Conzinha com o id %s não encontrada!", id)));
        cozinhaRepository.delete(cozinha);
    }

}
