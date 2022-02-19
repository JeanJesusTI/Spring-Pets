package com.pets.readxml.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PetReadXmlHandlerException extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	ResponseEntity<Object> handleRegraNegocioException(RegraNegocioException ex, WebRequest request){
		String message = ex.getMessage();
		DefaultError erro = new DefaultError(message);

		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler
	ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request){
		DefaultError erro = gerarMensagemErro(ex);
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	private DefaultError gerarMensagemErro(HttpClientErrorException ex) {
		String message = validarTipoErro(ex);
		return new DefaultError(message);
	}

	private String validarTipoErro(HttpClientErrorException ex) {
		if(ex.getStatusText().equals("Not Found")){
			return "Pet Not found!";
		}
		System.out.println(ex.getStatusText());
		return ex.toString();
	}

}
