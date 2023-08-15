package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.conjuge.application.service.ConjugeService;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.repository.MensagemRepository;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MensagemApplicationService implements MensagemService {

	private final MensagemRepository mensagemRepository;
	private final ConjugeService conjugeService;
	
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

	@Override
	public MensagemDetalhadaResponse buscaMensagemPorId(UUID idConjuge, UUID idMensagem) {
		log.info("[inicia] MensagemApplicationService - buscaMensagemPorId");
		Mensagem mensagem = mensagemRepository.buscaMensagemPorId(idConjuge, idMensagem);
		log.info("[finaliza] MensagemApplicationService - buscaMensagemPorId");
		return new MensagemDetalhadaResponse(mensagem);
	}

	@Override
	public void alteraMensagemAtravesId(UUID idConjuge, UUID idMensagem, @Valid MensagemAlteracaoRequest mensagemAlteracaoRequest) {
		log.info("[inicia] MensagemApplicationService - alteraMensagemAtravesId");
		conjugeService.getConjugePorId(null, idConjuge);
		Mensagem mensagem = mensagemRepository.buscaMensagemPorId(idConjuge, idMensagem);
		mensagem.altera(mensagemAlteracaoRequest);
		mensagemRepository.salvaMensagem(mensagem);
		log.info("[finaliza] MensagemApplicationService - alteraMensagemAtravesId");
		
	}

	@Override
	public void deletaMensagemPorId(UUID idConjuge, UUID idMensagem) {
		log.info("[inicia] MensagemApplicationService - deletaMensagemPorId");
		conjugeService.getConjugePorId(null, idConjuge);
		Mensagem mensagem = mensagemRepository.buscaMensagemPorId(idConjuge, idMensagem);
		mensagemRepository.deletaMensagem(mensagem);
		log.info("[finaliza] MensagemApplicationService - deletaMensagemPorId");
		
	}

	@Override
	public MensagemResponse buscaMensagemAleatoria() {
		log.info("[inicia] MensagemApplicationService - buscaMensagemAleatoria");
		log.info("[finaliza] MensagemApplicationService - buscaMensagemAleatoria");
		return null;
	}

}
