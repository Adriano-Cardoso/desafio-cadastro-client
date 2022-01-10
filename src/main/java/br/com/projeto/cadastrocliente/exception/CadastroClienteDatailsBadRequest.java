package br.com.projeto.cadastrocliente.exception;

public class CadastroClienteDatailsBadRequest extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CadastroClienteDatailsBadRequest(String menssage) {
		super(menssage);
	}
}
