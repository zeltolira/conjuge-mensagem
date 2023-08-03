package br.com.lembrete.conjugemensagem.conjuge.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeListResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.repository.ConjugeRepository;
import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ConjugeApplicationService implements ConjugeService {

	private final ConjugeRepository conjugeRepository;

	@Override
	public ConjugeResponse criaConjuge(UUID idUsuario, @Valid ConjugeRequest conjugeRequest) {
		log.info("[inicia] ConjugeApplicationService - criaConjuge");
		Conjuge conjuge = conjugeRepository.salvaConjuge(new Conjuge(idUsuario, conjugeRequest));
		log.info("[finaliza] ConjugeApplicationService - criaConjuge");
		return ConjugeResponse.builder()
				.idConjuge(conjuge.getIdConjuge())
				.build();
	}

	@Override
	public List<ConjugeListResponse> buscaTodosConjuges() {
		log.info("[inicia] ConjugeApplicationService - buscaTodosConjuges");
		List<Conjuge> conjuges = conjugeRepository.buscaTodosConjuges();
		log.info("[finaliza] ConjugeApplicationService - buscaTodosConjuges");
		return ConjugeListResponse.converte(conjuges);
	}

}
