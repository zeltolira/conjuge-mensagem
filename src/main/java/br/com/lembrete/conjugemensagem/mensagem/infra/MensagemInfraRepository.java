package br.com.lembrete.conjugemensagem.mensagem.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.handler.APIException;
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
	public List<Mensagem> buscaTodasMensagens(Conjuge conjuge) {
		log.info("[inicia] MensagemInfraRepository - buscaTodasMensagens");
		List<Mensagem> todasMensagens = mensagemSpringDataJPARepository.findAllByConjuge(conjuge);
		log.info("[finaliza] MensagemInfraRepository - buscaTodasMensagens");
		return todasMensagens;
	}

	@Override
	public Mensagem buscaMensagemPorId(Long idMensagem) {
		log.info("[inicia] MensagemInfraRepository - buscaMensagemPorId");
		var mensagem = mensagemSpringDataJPARepository.findById(idMensagem)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Mensagem não encontrada para o idConjuge "));
		log.info("[finaliza] MensagemInfraRepository - buscaMensagemPorId");
		return mensagem;
	}

	@Override
	public void deletaMensagem(Long idMensagem) {
		log.info("[inicia] MensagemInfraRepository - deletaMensagem");
		mensagemSpringDataJPARepository.deleteById(idMensagem);
		log.info("[finaliza] MensagemInfraRepository - deletaMensagem");
		
	}
}