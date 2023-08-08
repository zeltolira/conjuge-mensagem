package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;

public interface MensagemService {
	MensagemResponse criaMensagem(UUID idConjuge, MensagemRequest mensagemRequest);
	List<MensagemListResponse> buscaTodasMensagem();
	MensagemDetalhadaResponse buscaMensagemPorId(UUID idConjuge, UUID idMensagem);
	void alteraMensagemAtravesId(UUID idConjuge, UUID idMensagem, MensagemAlteracaoRequest mensagemAlteracaoRequest);
}
