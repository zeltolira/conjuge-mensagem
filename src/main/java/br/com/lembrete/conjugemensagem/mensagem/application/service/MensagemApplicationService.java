package br.com.lembrete.conjugemensagem.mensagem.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.conjuge.application.repository.ConjugeRepository;
import br.com.lembrete.conjugemensagem.conjuge.application.service.ConjugeService;
import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.repository.MensagemRepository;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import br.com.lembrete.conjugemensagem.usuario.application.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MensagemApplicationService implements MensagemService {

	private final MensagemRepository mensagemRepository;
	private final ConjugeService conjugeService;
	private final ConjugeRepository conjugeRepository;
	private final UsuarioRepository usuarioRepository;
	
	@Override
	public MensagemResponse criaMensagem(UUID idUsuario, MensagemRequest mensagemRequest) {
		log.info("[inicia] MensagemApplicationService - criaMensagem");
		Conjuge conjuge =  usuarioRepository.buscaUsuarioPorId(idUsuario).getConjuge();
		Mensagem mensagem = mensagemRepository.salvaMensagem(new Mensagem(conjuge, mensagemRequest));
		log.info("[finaliza] MensagemApplicationService - criaMensagem");
		return MensagemResponse.builder()
				.idMensagem(mensagem.getIdMensagem())
				.build();
	}

	@Override
	public List<MensagemListResponse> buscaTodasMensagem(UUID idUsuario) {
		log.info("[inicia] MensagemApplicationService - buscaTodasMensagem");
		Conjuge conjuge = usuarioRepository.buscaUsuarioPorId(idUsuario).getConjuge();
		List<Mensagem> mensagens = mensagemRepository.buscaTodasMensagens(conjuge);
		log.info("[finaliza] MensagemApplicationService - buscaTodasMensagem");
		return MensagemListResponse.converte(mensagens);
	}

	@Override
	public MensagemDetalhadaResponse buscaMensagemPorId(UUID idUsuario, Long idMensagem) {
		log.info("[inicia] MensagemApplicationService - buscaMensagemPorId");
		
		Mensagem mensagem = mensagemRepository.buscaMensagemPorId(idMensagem);
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
}
