package br.com.mayke.my_food.repository;

import br.com.mayke.my_food.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
