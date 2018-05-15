package br.com.fullstackAngularSpring.service.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fullstackAngularSpring.exceptions.FullStackExceptionHandler.Error;
import br.com.fullstackAngularSpring.service.exceptions.PessoaInativaException;

@ControllerAdvice
public class ExceptionHandlerBusiness extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource menssageSource;
	
	@ExceptionHandler({PessoaInativaException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException (PessoaInativaException ex, WebRequest request ) {
		String mensagemUsuario = menssageSource.getMessage("mensagem.pessoa-inativa", null, LocaleContextHolder.getLocale());
		String causa = ex.getMessage();
		List<Error> erros = new ArrayList<>();
		erros.add(new Error(mensagemUsuario, causa));
		return handleExceptionInternal(ex, erros , new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
}
