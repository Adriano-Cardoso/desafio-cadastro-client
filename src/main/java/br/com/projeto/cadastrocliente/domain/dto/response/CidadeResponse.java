package br.com.projeto.cadastrocliente.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CidadeResponse {

	@ApiModelProperty(position = 1, required = false, value = "id da cidade", name = "cidadeId", dataType = "Long", example = "1")
	private Long cidadeId;

	@ApiModelProperty(position = 1, required = false, value = "nome da cidade", name = "nomeCidade", dataType = "String", example = "risadinha 123")
	private String nomeCidade;

	@ApiModelProperty(position = 1, required = false, value = "nome do estado", name = "estado", dataType = "String", example = "risadinha")
	private String estado;

	
	
}
