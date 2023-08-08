package br.com.lembrete.conjugemensagem.mensagem.application.api.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class MensagemRequest {
	@NotBlank
	private String mensagemAReceber;
	
	private LocalDateTime dataHoraDoCadastro;
}
