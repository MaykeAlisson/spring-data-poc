package br.com.mayke.my_food.repository.cozinha;

import br.com.mayke.my_food.entities.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    Optional<Cozinha> findById(Long id);

    List<Cozinha> findAll();
}
