package br.com.lembrete.conjugemensagem.conjuge.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;

public interface ConjugeRepository {
	Conjuge salvaConjuge(Conjuge conjuge);
	List<Conjuge> buscaTodosConjuges();
	Conjuge getConjugePorId(UUID idUsuario, UUID idConjuge);
	void deletaConjuge(Conjuge conjuge);
}
