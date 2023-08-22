package br.com.lembrete.conjugemensagem.conjuge.application.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;

public interface ConjugeSpringDataJPARepository extends JpaRepository<Conjuge, UUID>{

}
