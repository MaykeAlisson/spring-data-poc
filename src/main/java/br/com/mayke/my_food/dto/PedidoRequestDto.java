package br.com.mayke.my_food.dto;

import br.com.mayke.my_food.entities.ItemPedido;
import br.com.mayke.my_food.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto implements Serializable {

    @NotNull
    private List<ItemPedido> itens;

    @NotNull
    private Long idRestaurante;

    @NotNull
    private Long idFormaPagamento;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Status status;

}
