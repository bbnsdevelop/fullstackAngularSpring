package br.com.fullstackAngularSpring.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
		return handleExceptionInternal(ex, new Error(mensagemUsuario, causa), headers, HttpStatus.BAD_REQUEST, request);
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
