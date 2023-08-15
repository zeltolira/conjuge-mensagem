package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import java.util.UUID;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import lombok.Value;

@Value
public class MensagemAleatoriaResponse {
	private UUID idMensagem;
	private String mensagemAReceber;

	
	public MensagemAleatoriaResponse(Mensagem mensagemAleatoria) {
		this.idMensagem = mensagemAleatoria.getIdMensagem();
		this.mensagemAReceber = mensagemAleatoria.getMensagemAReceber();
	}
}