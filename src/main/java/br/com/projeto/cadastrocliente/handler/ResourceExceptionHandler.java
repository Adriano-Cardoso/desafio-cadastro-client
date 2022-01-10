package br.com.projeto.cadastrocliente.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.projeto.cadastrocliente.exception.CadastroClienteDatailsBadRequest;
import br.com.projeto.cadastrocliente.exception.CadastroClienteDetails;
import br.com.projeto.cadastrocliente.exception.CidadeExistenteException;
import br.com.projeto.cadastrocliente.exception.CidadeResourceNotFoundException;
import br.com.projeto.cadastrocliente.exception.ClienteExistenteException;
import br.com.projeto.cadastrocliente.exception.ClienteResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ClienteResourceNotFoundException.class)
	public ResponseEntity<CadastroClienteDetails> handlerResourceNotFound(ClienteResourceNotFoundException e,
			HttpServletRequest request) {

		CadastroClienteDetails err = new CadastroClienteDetails();

		err.setCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<Object> handlerExistingException(ClienteExistenteException ex, HttpServletRequest request) {

		CadastroClienteDetails erro = new CadastroClienteDetails();

		erro.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		erro.setMessage(ex.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
	@ExceptionHandler(CidadeExistenteException.class)
	public ResponseEntity<Object> handlerExistingCidadeException(CidadeExistenteException ex, HttpServletRequest request) {

		CadastroClienteDetails erro = new CadastroClienteDetails();

		erro.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		erro.setMessage(ex.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
	
	@ExceptionHandler(CidadeResourceNotFoundException.class)
	public ResponseEntity<CadastroClienteDetails> handlerCidadeResourceNotFound(CidadeResourceNotFoundException e,
			HttpServletRequest request) {

		CadastroClienteDetails err = new CadastroClienteDetails();

		err.setCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	

	@ExceptionHandler(CadastroClienteDatailsBadRequest.class)
	public ResponseEntity<Object> handlerBadRequest(CadastroClienteDatailsBadRequest ex, HttpServletRequest request) {

		CadastroClienteDatailsBadRequest details = new CadastroClienteDatailsBadRequest(
				"Erro, favor verificar os padrões solicitado");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);

	}
}
