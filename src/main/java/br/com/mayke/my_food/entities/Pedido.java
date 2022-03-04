package br.com.mayke.my_food.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PEDIDO_ID", insertable = true, updatable = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(name = "FINALIZADO")
    private Boolean finalizado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAGAMENTO_ID")
    private FormaDePagamento formaPagamento;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "RESTAURANTE_ID")
    private Restaurante restaurante;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PEDIDO_ID", insertable = true, updatable = true)
    private Set<Status> status = new HashSet<>();

    @CreationTimestamp
    @Column(name = "DATA_PEDIDO")
    private LocalDateTime dataPedido;

    @UpdateTimestamp
    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
}
