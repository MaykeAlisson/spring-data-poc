package br.com.mayke.my_food.repository.pedido;

import br.com.mayke.my_food.entities.Cozinha;
import br.com.mayke.my_food.entities.Pedido;
import br.com.mayke.my_food.entities.Usuario;
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
}
