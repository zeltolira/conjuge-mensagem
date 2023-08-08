package br.com.lembrete.conjugemensagem.mensagem.application.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class MensagemAlteracaoRequest {
	@NotBlank
	private String mensagemAReceber;
}
