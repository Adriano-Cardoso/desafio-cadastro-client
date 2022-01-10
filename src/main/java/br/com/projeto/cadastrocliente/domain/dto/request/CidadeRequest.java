package br.com.projeto.cadastrocliente.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeRequest {
	
	@NotBlank(message = "O valor do campo 'nomeCidade' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nomeCidade' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'nomeCidade' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 1, value = "nome da cidade", name = "nomeCidade", dataType = "String", example = "risadinha")
	private String nomeCidade;

	@NotBlank(message = "O valor do campo 'estado' deve ser informado")
	@NotEmpty(message = "O valor do campo 'estado' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'estado' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 1, value = "nome do estado", name = "estado", dataType = "String", example = "risadinha 123")
	private String estado;

}
