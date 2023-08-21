package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import lombok.Value;

@Value
public class MensagemDetalhadaResponse {
	private Long idMensagem;
	private String mensagemAReceber;

	public MensagemDetalhadaResponse(Mensagem mensagem) {
		this.idMensagem = mensagem.getIdMensagem();
		this.mensagemAReceber = mensagem.getMensagemAReceber();
	}
}