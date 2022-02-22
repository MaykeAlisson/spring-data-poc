package br.com.mayke.my_food.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String msg) {
        super(msg);
    }
}
