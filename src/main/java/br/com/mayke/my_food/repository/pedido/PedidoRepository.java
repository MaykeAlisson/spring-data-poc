package br.com.mayke.my_food.repository.pedido;

import br.com.mayke.my_food.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
