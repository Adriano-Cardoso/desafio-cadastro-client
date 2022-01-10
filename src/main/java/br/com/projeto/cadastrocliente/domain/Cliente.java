package br.com.projeto.cadastrocliente.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.projeto.cadastrocliente.domain.dto.request.ClienteRequest;
import br.com.projeto.cadastrocliente.domain.dto.request.ClienteUpdateRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;
	private String nomeCompleto;
	private String sexo;
	private Date dataNascimento;
	private Integer idade;
	@ManyToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "cidade_id", insertable = true)
	private Cidade cidade;

	public void updateCliente(ClienteUpdateRequest cliente) {

		this.nomeCompleto = cliente.getNomeCompleto();

	}
	

	public static Cliente of(ClienteRequest clienteRequest) {
		Cidade cidade = Cidade.builder().nomeCidade(clienteRequest.getCidade().getNomeCidade()).estado(clienteRequest.getCidade().getEstado()).build();
		return Cliente.builder().nomeCompleto(clienteRequest.getNomeCompleto()).sexo(clienteRequest.getSexo())
				.dataNascimento(clienteRequest.getDataNascimento()).idade(clienteRequest.getIdade()).cidade(cidade).build();
	}

	public ClienteResponse toDto() {
		return ClienteResponse.builder().clienteId(this.clienteId).nomeCompleto(this.nomeCompleto).sexo(this.sexo).idade(this.idade)
				.dataNascimento(this.dataNascimento).cidadeId(this.cidade.getCidadeId()).nome(this.cidade.getNomeCidade()).estado(this.cidade.getEstado()).build();
	}
	
	
}
