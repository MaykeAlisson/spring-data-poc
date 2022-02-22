package br.com.mayke.my_food.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class RestauranteRequestDto implements Serializable {

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal taxaFrete;

    @NotNull
    private Long idCozinha;
}
