package br.com.mayke.my_food.repository.pedido;

import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.entities.Pedido;
import br.com.mayke.my_food.entities.Usuario;
import br.com.mayke.my_food.view.InfoPedidoView;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @EntityGraph(attributePaths = {"itens", "formaPagamento", "restaurante", "restaurante.cozinha", "usuario", "usuario.endereco", "status"})
    List<Pedido> findByUsuario(Usuario usuario);

    @EntityGraph(attributePaths = {"itens", "formaPagamento", "restaurante", "restaurante.cozinha", "usuario", "usuario.endereco", "status"})
    @Query("SELECT p FROM Pedido p INNER JOIN p.restaurante r WHERE r.cozinha = :cozinha ")
    List<Pedido> buscarPorIdCozinha(Cozinha cozinha);

//    @EntityGraph(attributePaths = {"itens", "formaPagamento", "restaurante", "restaurante.cozinha", "usuario", "usuario.endereco", "status"})
    @Query(value = "SELECT p.* FROM pedido as p INNER JOIN restaurante as r on p.restaurante_id = r.id WHERE r.id = :idRestaurante", nativeQuery = true)
    List<Pedido> buscarPorIdRestaurante(Long idRestaurante);

    @Query(value = "select  u.nome as nome, u.ddd as ddd, u.telefone as telefone, pe.data_pedido as data, " +
            "pe.finalizado as finalizado, pag.descricao as descricao \n" +
            "from pedido pe inner join usuario u on pe.usuari_id = u.id " +
            "inner join pagamento pag on pe.pagamento_id = pag.id \n" +
            "where pe.id = :idPedido", nativeQuery = true)
    InfoPedidoView infoPedido(Long idPedido);
}
