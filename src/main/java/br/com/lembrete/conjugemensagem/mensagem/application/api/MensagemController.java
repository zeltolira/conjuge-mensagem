package br.com.lembrete.conjugemensagem.mensagem.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
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

}