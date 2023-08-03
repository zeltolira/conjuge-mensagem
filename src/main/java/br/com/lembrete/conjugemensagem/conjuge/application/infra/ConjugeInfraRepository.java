package br.com.lembrete.conjugemensagem.conjuge.application.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lembrete.conjugemensagem.conjuge.application.repository.ConjugeRepository;
import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
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

}
