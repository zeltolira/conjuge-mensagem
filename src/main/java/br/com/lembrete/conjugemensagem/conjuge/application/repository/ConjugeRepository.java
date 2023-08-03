package br.com.lembrete.conjugemensagem.conjuge.application.repository;

import java.util.List;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;

public interface ConjugeRepository {
	Conjuge salvaConjuge(Conjuge conjuge);
	List<Conjuge> buscaTodosConjuges();
}
