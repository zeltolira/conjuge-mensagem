package br.com.lembrete.conjugemensagem.conjuge.application.api.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ConjugeRequest {
	@NotBlank
	private String nomeConjuge;
	@NotNull
	private Sexo sexo;
	@NotBlank
	private String celular;
	@NotNull
	private LocalDate dataNascimento;

	private LocalDateTime dataHoraDoCadastro;
}
