package br.com.projeto.cadastrocliente.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteUpdateRequest {
	
	@NotBlank(message = "O valor do campo 'nomeCompleto' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	private String nomeCompleto;

}
