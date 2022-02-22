package br.com.mayke.my_food.service.pedido;

import br.com.mayke.my_food.dto.PedidoRequestDto;
import br.com.mayke.my_food.entities.Pedido;

public interface PedidoService {
    Pedido create(PedidoRequestDto pedidoRequest);
}
