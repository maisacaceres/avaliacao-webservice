package br.com.maisa.avaliacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -178803168488589571L;

	public UserNotFoundException(String name) {
		super("Could not find '" + name + "' user.");
	}
}