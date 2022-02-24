package br.com.mayke.my_food.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "RESTAURANTE")
public class Restaurante implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TAXA_FRETE")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "COZINHA_ID")
    private Cozinha cozinha;

}
