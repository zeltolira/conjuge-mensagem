package br.com.lembrete.conjugemensagem.mensagem.application.api.response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import lombok.Value;

@Value
public class MensagemListResponse {
	private UUID idMensagem;
	private String mensagemAReceber;
	
	
	public static List<MensagemListResponse> converte(List<Mensagem> mensagens) {
		return mensagens.stream()
				.map(MensagemListResponse::new)
				.collect(Collectors.toList());
	}


	public MensagemListResponse(Mensagem mensagens) {
		this.idMensagem = mensagens.getIdMensagem();
		this.mensagemAReceber = mensagens.getMensagemAReceber();
	}
	
	
}
