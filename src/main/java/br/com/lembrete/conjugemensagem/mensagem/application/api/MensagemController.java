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
	public MensagemResponse postMensagem(UUID idUsuario, MensagemRequest mensagemRequest) {
		log.info("[inicia] MensagemController - postMensagem");
		MensagemResponse mensagemCriada =  mensagemService.criaMensagem(idUsuario, mensagemRequest);
		log.info("[finaliza] MensagemController - postMensagem");
		return mensagemCriada;
	}

	@Override
	public List<MensagemListResponse> getTodasMensagens(UUID idUsuario) {
		log.info("[inicia] MensagemController - getTodasMensagens");
		List<MensagemListResponse> mensagens = mensagemService.buscaTodasMensagem(idUsuario);
		log.info("[finaliza] MensagemController - getTodasMensagens");
		return mensagens;
	}

	@Override
	public MensagemDetalhadaResponse getMensagemPorId(UUID idUsuario, Long idMensagem) {
		log.info("[inicia] MensagemController - getMensagemPorId");
		MensagemDetalhadaResponse mensagemDetalhada = mensagemService.buscaMensagemPorId(idUsuario, idMensagem);
		log.info("[finaliza] MensagemController - getMensagemPorId");
		return mensagemDetalhada;
	}

	@Override
	public void PatchMensagem(Long idMensagem, MensagemAlteracaoRequest mensagemAlteracaoRequest) {
		log.info("[inicia] MensagemController - PatchMensagem");
		mensagemService.alteraMensagemAtravesId(idMensagem, mensagemAlteracaoRequest);
		log.info("[finaliza] MensagemController - PatchMensagem");
		
	}

	@Override
	public void deletaMensagemPorId(Long idMensagem) {
		log.info("[inicia] MensagemController - deletaMensagemPorId");
		mensagemService.deletaMensagemPorId(idMensagem);
		log.info("[finaliza] MensagemController - deletaMensagemPorId");
	}

	
}