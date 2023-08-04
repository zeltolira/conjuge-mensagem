package br.com.lembrete.conjugemensagem.conjuge.application.service;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeAlteracaoRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeDetalhadoResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeListResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import jakarta.validation.Valid;

public interface ConjugeService {
	ConjugeResponse criaConjuge(UUID idUsuario, @Valid ConjugeRequest conjugeRequest);
	List<ConjugeListResponse> buscaTodosConjuges();
	ConjugeDetalhadoResponse getConjugePorId(UUID idUsuario, UUID idConjuge);
	void alteraConjugeAtravesId(UUID idUsuario, UUID idConjuge, @Valid ConjugeAlteracaoRequest conjugeAlteracaoRequest);
}
