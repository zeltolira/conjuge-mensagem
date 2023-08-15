package br.com.lembrete.conjugemensagem.mensagem.application.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;

public interface MensagemSpringDataJPARepository extends JpaRepository<Mensagem, UUID>{
//	Mensagem findRandomMessageByIdConjuge(UUID idConjuge);
}
