package br.com.projeto.cadastrocliente.domain.dto.response;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
	
	
	@ApiModelProperty(position = 1, required = false, value = "id do cliente", name = "clienteId", dataType = "Long", example = "1")
	private Long clienteId;
	@ApiModelProperty(position = 2, required = false, value = "nome do cliente", name = "nomeCompleto", dataType = "String", example = "Risadinha 123")
	private String nomeCompleto;
	@ApiModelProperty(position = 3, required = false, value = "sexo do cliente", name = "sexo", dataType = "String", example = "M")
	private String sexo;
	@ApiModelProperty(position = 4, required = false, value = "data de nascimento do cliente", name = "dataNascimento", dataType = "Date", example = "17/10/1998")
	private Date dataNascimento;
	@ApiModelProperty(position = 5, required = false, value = "idade do cliente", name = "idade", dataType = "Integer", example = "23")
	private Integer idade;
	@ApiModelProperty(position = 6, required = false, value = "cidade do cliente", name = "cidade", dataType = "CidadeResponse", example = "1")
	private CidadeResponse cidade;
	
	@Builder
	public ClienteResponse(Long clienteId, String nomeCompleto, String sexo, Date dataNascimento, Integer idade, Long cidadeId, String nome, String estado) {
		this.clienteId = clienteId;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.cidade = new CidadeResponse(cidadeId, nome, estado);
	}
	
	

}
