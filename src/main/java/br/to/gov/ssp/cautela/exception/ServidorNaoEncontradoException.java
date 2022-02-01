package br.to.gov.ssp.cautela.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ServidorNaoEncontradoException extends Exception{
	
	public ServidorNaoEncontradoException(Long id) {
        super(String.format("Servidor com ID %s não encontrado!", id));
	}

}
