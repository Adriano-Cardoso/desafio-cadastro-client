package br.com.projeto.cadastrocliente.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteUpdateResponse {
		
	@ApiModelProperty(position = 1, required = false, value = "id do cliente", name = "clienteId", dataType = "Long", example = "1")
	private Long clienteId;

	@ApiModelProperty(position = 2, required = false, value = "nome do cliente", name = "nomeCompleto", dataType = "String", example = "Risadinha 123")
	private String nomeCompleto;

}
