package br.com.projeto.cadastrocliente.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.Min;
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
public class ClienteRequest  {
	
	@NotBlank(message = "O valor do campo 'nomeCompleto' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 1, value = "nome do cliente", name = "nomeCompleto", dataType = "String", example = "risadinha")
	private String nomeCompleto;

	@NotBlank(message = "O valor do campo 'sexo' deve ser informado")
	@NotEmpty(message = "O valor do campo 'sexo' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'sexo' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 2, value = "nome do cliente", name = "nomeCompleto", dataType = "String", example = "M")
	private String sexo;

	@NotBlank(message = "O valor do campo 'dataNascimento' deve ser informado")
	@NotEmpty(message = "O valor do campo 'dataNascimento' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'dataNascimento' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 3, value = "data de nascimento do cliente", name = "dataNascimento", dataType = "Date")
	private Date dataNascimento;

	@NotBlank(message = "O valor do campo 'nomeCompleto' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'nomeCompleto' é obrigatório no corpo da requisição")
	@Min(value = 1, message = "O campo 'nomeCompleto' está com valor mínimo ('{value}') inválido para o valor '${validatedValue}'")
	@ApiModelProperty(position = 4, value = "idade do cliente", name = "idade", dataType = "Integer", example = "20")
	private Integer idade;

	@NotBlank(message = "O valor do campo 'cidade' deve ser informado")
	@NotEmpty(message = "O valor do campo 'cidade' é obrigatório no corpo da requisição")
	@NotNull(message = "O valor do campo 'cidade' é obrigatório no corpo da requisição")
	@ApiModelProperty(position = 5, value = "cidade do cliente", name = "cidade", dataType = "CidadeRequest", example = "1")
	private CidadeRequest cidade;
	

}
