package br.com.lembrete.conjugemensagem.conjuge.application.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ConjugeResponse {
	private UUID idConjuge;
}
