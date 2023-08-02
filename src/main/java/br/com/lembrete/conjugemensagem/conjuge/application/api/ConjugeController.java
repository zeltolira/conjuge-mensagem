package br.com.lembrete.conjugemensagem.conjuge.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.conjuge.application.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.response.ConjugeResponse;
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

}
