package br.com.mayke.my_food.service.pedido.impl;

import br.com.mayke.my_food.dto.PedidoRequestDto;
import br.com.mayke.my_food.entities.FormaDePagamento;
import br.com.mayke.my_food.entities.Pedido;
import br.com.mayke.my_food.entities.Restaurante;
import br.com.mayke.my_food.entities.Usuario;
import br.com.mayke.my_food.exception.NotFoundException;
import br.com.mayke.my_food.repository.FormaDePagamentoRepository;
import br.com.mayke.my_food.repository.ItemPedidoRepository;
import br.com.mayke.my_food.repository.StatusRepository;
import br.com.mayke.my_food.repository.pedido.PedidoRepository;
import br.com.mayke.my_food.repository.restaurante.RestauranteRepository;
import br.com.mayke.my_food.repository.usuario.UsuarioRepository;
import br.com.mayke.my_food.service.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.lang.String.format;
import static java.util.Collections.singleton;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public Pedido create(PedidoRequestDto pedidoRequest) {

        final Usuario usuario = usuarioRepository.findById(pedidoRequest.getIdUsuario())
                .orElseThrow(() -> new NotFoundException(format("Não foi encontrado usuario co o id %s ", pedidoRequest.getIdUsuario())));

        FormaDePagamento formaDePagamento = formaDePagamentoRepository.findById(pedidoRequest.getIdFormaPagamento())
                .orElseThrow(() -> new NotFoundException(format("nao foi encontrado pagamento com o id %s ", pedidoRequest.getIdFormaPagamento())));

        Restaurante restaurante = restauranteRepository.findById(pedidoRequest.getIdRestaurante())
                .orElseThrow(() -> new NotFoundException(format("não foi encontrado restaurante com o id %s ", pedidoRequest.getIdRestaurante())));

        final Pedido pedido = Pedido.builder()
                .itens(pedidoRequest.getItens())
                .usuario(usuario)
                .formaPagamento(formaDePagamento)
                .restaurante(restaurante)
                .status(singleton(pedidoRequest.getStatus()))
                .finalizado(false)
                .dataPedido(LocalDateTime.now())
                .build();
        return pedidoRepository.save(pedido);
    }
}
