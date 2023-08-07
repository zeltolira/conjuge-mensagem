package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import java.util.UUID;

import lombok.Value;

@Value
public class MensagemResponse {
	private UUID idMensagem;
}
