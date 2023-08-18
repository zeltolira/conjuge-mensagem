package br.com.lembrete.conjugemensagem.conjuge.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeAlteracaoRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeDetalhadoResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeListResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.repository.ConjugeRepository;
import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.usuario.application.infra.UsuarioSpringDataJPARepository;
import br.com.lembrete.conjugemensagem.usuario.application.repository.UsuarioRepository;
import br.com.lembrete.conjugemensagem.usuario.application.service.UsuarioService;
import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ConjugeApplicationService implements ConjugeService {

	private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;
	private final ConjugeRepository conjugeRepository;
	private final UsuarioService usuarioService;
	private final UsuarioRepository usuarioRepository;

	@Override
	public ConjugeResponse criaConjuge(UUID idUsuario, ConjugeRequest conjugeRequest) {
		log.info("[inicia] ConjugeApplicationService - criaConjuge");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		Conjuge conjuge = conjugeRepository.salvaConjuge(new Conjuge(usuario, conjugeRequest));
		usuario.addConjuge(conjuge);
		log.info("[finaliza] ConjugeApplicationService - criaConjuge");
		return ConjugeResponse.builder().idConjuge(conjuge.getIdConjuge()).build();
	}

	@Override
	public List<ConjugeListResponse> buscaTodosConjuges() {
		log.info("[inicia] ConjugeApplicationService - buscaTodosConjuges");
		List<Conjuge> conjuges = conjugeRepository.buscaTodosConjuges();
		log.info("[finaliza] ConjugeApplicationService - buscaTodosConjuges");
		return ConjugeListResponse.converte(conjuges);
	}

	@Override
	public ConjugeDetalhadoResponse getConjugePorId(UUID idConjuge) {
		log.info("[inicia] ConjugeApplicationService - getConjugePorId");
		Conjuge conjuge = conjugeRepository.getConjugePorId(idConjuge);
		log.info("[finaliza] ConjugeApplicationService - getConjugePorId");
		return new ConjugeDetalhadoResponse(conjuge);
	}

	@Override
	public void alteraConjugeAtravesId(UUID idConjuge,ConjugeAlteracaoRequest conjugeAlteracaoRequest) {
		log.info("[inicia] ConjugeApplicationService - alteraConjugeAtravesId");
		Conjuge conjuge = conjugeRepository.getConjugePorId(idConjuge);
		conjuge.altera(conjugeAlteracaoRequest);
		conjugeRepository.salvaConjuge(conjuge);
		log.info("[finaliza] ConjugeApplicationService - alteraConjugeAtravesId");

	}

	@Override
	public void deletaConjugePorId(UUID idConjuge) {
		log.info("[inicia] ConjugeApplicationService - alteraConjugeAtravesId");
		Conjuge conjuge = conjugeRepository.getConjugePorId(idConjuge);
		conjugeRepository.deletaConjuge(conjuge);
		log.info("[finaliza] ConjugeApplicationService - alteraConjugeAtravesId");

	}

}
