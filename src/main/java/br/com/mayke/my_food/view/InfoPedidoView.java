package br.com.mayke.my_food.view;

import java.time.LocalDateTime;

public interface InfoPedidoView {

    String getNome();
    String getDdd();
    String getTelefone();
    LocalDateTime getData();
    Integer getFinalizado();
    String getDescricao();

}
