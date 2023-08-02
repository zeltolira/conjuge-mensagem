package br.com.lembrete.conjugemensagem.conjuge.application.service;

import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import jakarta.validation.Valid;

public interface ConjugeService {
	ConjugeResponse criaConjuge(UUID idUsuario, @Valid ConjugeRequest conjugeRequest);
}
