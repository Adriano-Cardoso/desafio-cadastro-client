package br.com.projeto.cadastrocliente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "CIDADE")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cidadeId;
	private String nomeCidade;
	private String estado;

	public void updateCidade(CidadeRequest cidade) {

		this.nomeCidade = cidade.getNomeCidade();

		this.estado = cidade.getEstado();
	}

	public CidadeResponse toDto() {
		return CidadeResponse.builder().cidadeId(this.cidadeId).nomeCidade(this.nomeCidade).estado(this.estado).build();
	}

	public static Cidade of(CidadeRequest cidadeRequest) {
		return Cidade.builder().nomeCidade(cidadeRequest.getNomeCidade()).estado(cidadeRequest.getEstado())
				.build();
	}

}