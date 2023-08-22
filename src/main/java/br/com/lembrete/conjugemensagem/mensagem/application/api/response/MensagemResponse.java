package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MensagemResponse {
	Long idMensagem;
}
