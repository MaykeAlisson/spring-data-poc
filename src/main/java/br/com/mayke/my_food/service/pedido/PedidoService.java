package br.com.mayke.my_food.service.pedido;

import br.com.mayke.my_food.dto.PedidoRequestDto;
import br.com.mayke.my_food.entities.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido create(PedidoRequestDto pedidoRequest);

    List<Pedido> findByCozinha(Long idCozinha);

    List<Pedido> findByUser(Long idUser);

    List<Pedido> findByRestaurante(Long id);
}
