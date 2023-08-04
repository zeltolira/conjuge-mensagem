package br.com.lembrete.conjugemensagem.conjuge.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeDetalhadoResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeListResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.service.ConjugeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ConjugeController implements ConjugeAPI {

	private final ConjugeService conjugeService;

	@Override
	public ConjugeResponse postConjuge(UUID idUsuario, @Valid ConjugeRequest conjugeRequest) {
		log.info("[inicia] ConjugeController - postConjuge");
		ConjugeResponse conjugeCriado = conjugeService.criaConjuge(idUsuario, conjugeRequest);
		log.info("[finaliza] ConjugeController - postConjuge");
		return conjugeCriado;
	}

	@Override
	public List<ConjugeListResponse> getTodosConjuges() {
		log.info("[inicia] ConjugeController - getTodosConjuges");
		List<ConjugeListResponse> conjuges = conjugeService.buscaTodosConjuges();
		log.info("[finaliza] ConjugeController - getTodosConjuges");
		return conjuges;
	}

	@Override
	public ConjugeDetalhadoResponse getConjugePorId(UUID idUsuario, UUID idConjuge) {
		log.info("[inicia] ConjugeController - getConjugePorId");
		log.info("[idUsuario] {} - [idConjuge] {} - ", idUsuario, idConjuge);
		ConjugeDetalhadoResponse conjuge = conjugeService.getConjugePorId(idUsuario, idConjuge);
		log.info("[finaliza] ConjugeController - getConjugePorId");
		return conjuge;
	}

}
