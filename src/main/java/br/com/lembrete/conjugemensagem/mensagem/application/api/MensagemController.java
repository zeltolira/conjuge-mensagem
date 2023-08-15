package br.com.lembrete.conjugemensagem.mensagem.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.service.MensagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MensagemController implements MensagemAPI {

	private final MensagemService mensagemService;

	@Override
	public MensagemResponse postMensagem(UUID idConjuge, MensagemRequest mensagemRequest) {
		log.info("[inicia] MensagemController - postMensagem");
		MensagemResponse mensagemCriada =  mensagemService.criaMensagem(idConjuge, mensagemRequest);
		log.info("[finaliza] MensagemController - postMensagem");
		return mensagemCriada;
	}

	@Override
	public List<MensagemListResponse> getTodasMensagens() {
		log.info("[inicia] MensagemController - getTodasMensagens");
		List<MensagemListResponse> mensagens = mensagemService.buscaTodasMensagem();
		log.info("[finaliza] MensagemController - getTodasMensagens");
		return mensagens;
	}

	@Override
	public MensagemDetalhadaResponse getMensagemPorId(UUID idConjuge, UUID idMensagem) {
		log.info("[inicia] MensagemController - getMensagemPorId");
		MensagemDetalhadaResponse mensagemDetalhada = mensagemService.buscaMensagemPorId(idConjuge, idMensagem);
		log.info("[finaliza] MensagemController - getMensagemPorId");
		return mensagemDetalhada;
	}

	@Override
	public void PatchMensagem(UUID idConjuge, UUID idMensagem, MensagemAlteracaoRequest mensagemAlteracaoRequest) {
		log.info("[inicia] MensagemController - PatchMensagem");
		log.info("[IdConjuge] {} - [IdMensagem] {} - ", idConjuge, idMensagem);
		mensagemService.alteraMensagemAtravesId(idConjuge, idMensagem, mensagemAlteracaoRequest);
		log.info("[finaliza] MensagemController - PatchMensagem");
		
	}

	@Override
	public void deletaMensagemPorId(UUID idConjuge, UUID idMensagem) {
		log.info("[inicia] MensagemController - deletaMensagemPorId");
		log.info("[IdConjuge] {} - [IdMensagem] {} - ", idConjuge, idMensagem);
		mensagemService.deletaMensagemPorId(idConjuge, idMensagem);
		log.info("[finaliza] MensagemController - deletaMensagemPorId");
	}

	
}
