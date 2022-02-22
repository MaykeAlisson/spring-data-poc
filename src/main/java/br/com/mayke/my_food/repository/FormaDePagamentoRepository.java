package br.com.mayke.my_food.repository;

import br.com.mayke.my_food.entities.FormaDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {
}
