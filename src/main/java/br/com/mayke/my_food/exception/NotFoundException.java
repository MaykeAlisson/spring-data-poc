package br.com.mayke.my_food.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;

    public NotFoundException(String msg) {
		HttpStatus errorCode = HttpStatus.NOT_FOUND;
        this.message = msg;
    }

	@Override
	public String getMessage() {
		return message;
	}

}
