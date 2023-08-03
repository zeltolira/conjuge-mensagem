package br.com.lembrete.conjugemensagem.conjuge.application.api.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import lombok.Value;

@Value
public class ConjugeListResponse {
	private UUID idConjuge;
	private String nomeConjuge;
	private Sexo sexo;
	private String celular;
	private LocalDate dataNascimento;

	public static List<ConjugeListResponse> converte(List<Conjuge> conjuges) {
		return conjuges.stream()
				.map(ConjugeListResponse::new)
				.collect(Collectors.toList());
	}

	public ConjugeListResponse(Conjuge conjuge) {
		this.idConjuge = conjuge.getIdConjuge();
		this.nomeConjuge = conjuge.getNomeConjuge();
		this.sexo = conjuge.getSexo();
		this.celular = conjuge.getCelular();
		this.dataNascimento = conjuge.getDataNascimento();
	}
	
	
}
