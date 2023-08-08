package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.UUID;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;

public interface MensagemService {
	MensagemResponse criaMensagem(UUID idConjuge, MensagemRequest mensagemRequest);
}
