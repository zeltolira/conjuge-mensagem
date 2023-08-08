package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MensagemResponse {
	private UUID idMensagem;
}
