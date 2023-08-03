package br.com.lembrete.conjugemensagem.conjuge.application.api.response;

import java.time.LocalDate;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import lombok.Value;

@Value
public class ConjugeListResponse {
	private UUID idConjuge;
	private String nomeConjuge;
	private Sexo sexo;
	private String celular;
	private LocalDate dataNascimento;

}
