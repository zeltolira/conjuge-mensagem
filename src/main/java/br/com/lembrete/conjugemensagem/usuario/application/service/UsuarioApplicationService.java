package br.com.lembrete.conjugemensagem.usuario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioDetalhadoResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioListResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import br.com.lembrete.conjugemensagem.usuario.application.repository.UsuarioRepository;
import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {

	private final UsuarioRepository usuarioRespository;

	@Override
	public UsuarioResponse criaConjuge(UsuarioRequest usuarioRequest) {
		log.info("[inicia] UsuarioApplicationService - criaConjuge");
		Usuario usuario = usuarioRespository.salva(new Usuario(usuarioRequest));
		log.info("[finaliza] UsuarioApplicationService - criaConjuge");
		return UsuarioResponse.builder()
				.idUsuario(usuario.getIdUsuario())
				.build();
	}

	@Override
	public List<UsuarioListResponse> buscaTodosUsuario() {
		log.info("[inicia] UsuarioApplicationService - buscaTodosUsuario");
		List<Usuario> usuarios = usuarioRespository.buscaTodosUsuarios();
		log.info("[finaliza] UsuarioApplicationService - buscaTodosUsuario");
		return UsuarioListResponse.converte(usuarios);
	}

	@Override
	public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioApplicationService - buscaUsuarioPorId");
		log.info("[finaliza] UsuarioApplicationService - buscaUsuarioPorId");
		return null;
	}
}