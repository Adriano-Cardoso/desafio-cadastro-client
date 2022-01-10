package br.com.projeto.cadastrocliente.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.projeto.cadastrocliente.domain.Cidade;
import br.com.projeto.cadastrocliente.domain.dto.request.CidadeRequest;
import br.com.projeto.cadastrocliente.domain.dto.response.CidadeResponse;
import br.com.projeto.cadastrocliente.exception.CidadeExistenteException;
import br.com.projeto.cadastrocliente.exception.CidadeResourceNotFoundException;
import br.com.projeto.cadastrocliente.repository.CidadeRepository;
import br.com.projeto.cadastrocliente.validations.OnCreate;
import br.com.projeto.cadastrocliente.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Validated
@Service("CidadeService")
@Slf4j
public class CidadeService {

	private CidadeRepository cidadeRepository;

	@Validated(OnCreate.class)
	public CidadeResponse save(@Valid CidadeRequest cidadeDto) throws CidadeExistenteException {

		cidadeRepository.findByNomeCidade(cidadeDto.getNomeCidade()).ifPresent(m -> {
			throw new CidadeExistenteException("existing city: " + cidadeDto.getNomeCidade());
		});

		Cidade cidade = Cidade.of(cidadeDto);

		cidadeRepository.save(cidade);

		log.info("method=save id={}", cidade.getCidadeId());

		return cidade.toDto();
	}

	@Transactional
	@Validated(OnUpdate.class)
	public CidadeResponse update(@Valid CidadeRequest cidadeDto, Long cidadeId) throws CidadeExistenteException {

		Cidade cidade = cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new CidadeExistenteException("city not found: " + cidadeId));

		cidade.updateCidade(cidadeDto);

		log.info("method=update id={}", cidade.getCidadeId());

		return cidade.toDto();
	}

	public List<CidadeResponse> buscarNomeEstado(String estado) {

		log.info("method=buscarNomeEstado nomeEstado={}", estado);
		return this.cidadeRepository.findByEstado(estado);

	}

	public CidadeResponse buscarNomeDaCidade(String nomeCidade) {

		log.info("method=buscarNomeDaCidade nomeDaCidade={}", nomeCidade);

		return this.cidadeRepository.findByNomeCidade(nomeCidade)
				.orElseThrow(() -> new CidadeResourceNotFoundException("City not found: " + nomeCidade));
	}

	public List<CidadeResponse> listar() {

		log.info("method=listar");

		return this.cidadeRepository.findAllCidade();
	}

}
