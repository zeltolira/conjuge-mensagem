package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;

public interface MensagemService {
	MensagemResponse criaMensagem(UUID idUsuario, MensagemRequest mensagemRequest);
	List<MensagemListResponse> buscaTodasMensagem(UUID idUsuario);
	MensagemDetalhadaResponse buscaMensagemPorId(UUID idUsuario, Long idMensagem);
	void alteraMensagemAtravesId(Long idMensagem, MensagemAlteracaoRequest mensagemAlteracaoRequest);
	void deletaMensagemPorId(Long idMensagem);
}