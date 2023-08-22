package br.com.lembrete.conjugemensagem.conjuge.application.api.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import lombok.Value;

@Value
public class ConjugeDetalhadoResponse {
	private UUID idConjuge;
	private String nomeConjuge;
	private Sexo sexo;
	private String celular;
	private LocalDate dataNascimento;
	private LocalDateTime dataHoraUltimaAlteracao;
	
	public ConjugeDetalhadoResponse(Conjuge conjuge) {
		this.idConjuge = conjuge.getIdConjuge();
		this.nomeConjuge = conjuge.getNomeConjuge();
		this.sexo = conjuge.getSexo();
		this.celular = conjuge.getCelular();
		this.dataNascimento = conjuge.getDataNascimento();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}
}