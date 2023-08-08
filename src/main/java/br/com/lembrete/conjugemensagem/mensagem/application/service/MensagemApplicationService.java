package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.repository.MensagemRepository;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MensagemApplicationService implements MensagemService {

	private final MensagemRepository mensagemRepository;

	@Override
	public MensagemResponse criaMensagem(UUID idConjuge, MensagemRequest mensagemRequest) {
		log.info("[inicia] MensagemApplicationService - criaMensagem");
		Mensagem mensagem = mensagemRepository.salvaMensagem(new Mensagem(idConjuge, mensagemRequest));
		log.info("[finaliza] MensagemApplicationService - criaMensagem");
		return MensagemResponse.builder()
				.idMensagem(mensagem.getIdMensagem())
				.build();
	}

	@Override
	public List<MensagemListResponse> buscaTodasMensagem() {
		log.info("[inicia] MensagemApplicationService - buscaTodasMensagem");
		List<Mensagem> mensagens = mensagemRepository.buscaTodasMensagens();
		log.info("[finaliza] MensagemApplicationService - buscaTodasMensagem");
		return MensagemListResponse.converte(mensagens);
	}

}
