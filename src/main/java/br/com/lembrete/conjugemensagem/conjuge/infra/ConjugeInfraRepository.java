package br.com.lembrete.conjugemensagem.conjuge.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.lembrete.conjugemensagem.conjuge.application.repository.ConjugeRepository;
import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ConjugeInfraRepository implements ConjugeRepository {

	private final ConjugeSpringDataJPARepository conjugeSpringDataJPARepository;

	@Override
	public Conjuge salvaConjuge(Conjuge conjuge) {
		log.info("[inicia] ConjugeInfraRepository - salvaConjuge");
		conjugeSpringDataJPARepository.save(conjuge);
		log.info("[finaliza] ConjugeInfraRepository - salvaConjuge");
		return conjuge;
	}

	@Override
	public List<Conjuge> buscaTodosConjuges() {
		log.info("[inicia] ConjugeInfraRepository - buscaTodosConjuges");
		List<Conjuge> todosConjuges = conjugeSpringDataJPARepository.findAll();
		log.info("[finaliza] ConjugeInfraRepository - buscaTodosConjuges");
		return todosConjuges;
	}

	@Override
	public Conjuge getConjugePorId(UUID idUsuario, UUID idConjuge) {
		log.info("[inicia] ConjugeInfraRepository - getConjugePorId");
		var conjuge = conjugeSpringDataJPARepository.findById(idConjuge)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Conjuge não encotrado para o idConjuge " + idConjuge));
		log.info("[finaliza] ConjugeInfraRepository - getConjugePorId");
		return conjuge;
	}

	@Override
	public void deletaConjuge(Conjuge conjuge) {
		log.info("[inicia] ConjugeInfraRepository - deletaConjuge");
		conjugeSpringDataJPARepository.delete(conjuge);
		log.info("[finaliza] ConjugeInfraRepository - deletaConjuge");
		
	}

}
