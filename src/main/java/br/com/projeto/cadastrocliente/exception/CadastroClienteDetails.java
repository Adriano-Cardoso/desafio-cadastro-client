package br.com.projeto.cadastrocliente.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroClienteDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String message;
	
	
	
	

}
	
	

