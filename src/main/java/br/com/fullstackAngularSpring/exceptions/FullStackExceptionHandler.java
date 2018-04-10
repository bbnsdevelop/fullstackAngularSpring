package br.com.fullstackAngularSpring.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FullStackExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource menssageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagemUsuario = menssageSource.getMessage("mensagem.error", null, LocaleContextHolder.getLocale());
		String causa = ex.getCause().getMessage().toString();
		List<Error> erros = new ArrayList<>();
		erros.add(new Error(mensagemUsuario, causa));
		return handleExceptionInternal(ex, erros , headers, HttpStatus.BAD_REQUEST, request);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Error> erros = criarListaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, status, request);
	}
	
	private List<Error> criarListaErros(BindingResult bindingResult){
		List<Error> erros = new ArrayList<>();
		bindingResult.getFieldErrors().stream().forEach(erro ->{
			String mensagem = menssageSource.getMessage(erro, LocaleContextHolder.getLocale());
			String causa = erro.toString();
			erros.add(new Error(mensagem, causa));
		});
		return erros;
	}
	
	public static class Error{
		private String mensagem;
		private String causa;
		
		
		public Error(String mensagem, String causa) {
			this.mensagem = mensagem;
			this.causa = causa;
		}
		public String getMensagem() {
			return mensagem;
		}
		public String getCausa() {
			return causa;
		}
		
	}
}
