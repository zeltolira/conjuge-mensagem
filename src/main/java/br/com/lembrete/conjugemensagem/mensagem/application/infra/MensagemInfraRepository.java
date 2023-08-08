package br.com.lembrete.conjugemensagem.mensagem.application.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lembrete.conjugemensagem.mensagem.application.repository.MensagemRepository;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MensagemInfraRepository implements MensagemRepository {

	private final MensagemSpringDataJPARepository mensagemSpringDataJPARepository;
	

	@Override
	public Mensagem salvaMensagem(Mensagem mensagem) {
	log.info("[inicia] MensagemInfraRepository - salvaMensagem");
	mensagemSpringDataJPARepository.save(mensagem);
	log.info("[finaliza] MensagemInfraRepository - salvaMensagem");
	return mensagem;
	}


	@Override
	public List<Mensagem> buscaTodasMensagens() {
		log.info("[inicia] MensagemInfraRepository - buscaTodasMensagens");
		List<Mensagem> todasMensagens = mensagemSpringDataJPARepository.findAll();
		log.info("[finaliza] MensagemInfraRepository - buscaTodasMensagens");
		return todasMensagens;
	}

}
