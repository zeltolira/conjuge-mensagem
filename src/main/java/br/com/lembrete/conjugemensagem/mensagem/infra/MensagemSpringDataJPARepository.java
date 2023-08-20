package br.com.lembrete.conjugemensagem.mensagem.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;

public interface MensagemSpringDataJPARepository extends JpaRepository<Mensagem, Long>{
	List<Mensagem> findAllByConjuge(Conjuge conjuge);
}
