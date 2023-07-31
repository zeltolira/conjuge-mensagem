package br.com.lembrete.conjugemensagem.usuario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioAlteracaoRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioDetalhadoResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioListResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import br.com.lembrete.conjugemensagem.usuario.application.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {

	private final UsuarioService usuarioService;

	@Override
	public UsuarioResponse postConjuge(@Valid UsuarioRequest usuarioRequest) {
		log.info("[inicia] UsuarioController - postConjuge");
		UsuarioResponse usuarioCriado = usuarioService.criaConjuge(usuarioRequest);
		log.info("[finaliza] UsuarioController - postConjuge");
		return usuarioCriado;
	}

	@Override
	public List<UsuarioListResponse> getTodosUsuario() {
		log.info("[inicia] UsuarioController - getTodosUsuario");
		List<UsuarioListResponse> usuarios = usuarioService.buscaTodosUsuario();
		log.info("[finaliza] UsuarioController - getTodosUsuario");
		return usuarios;
	}

	@Override
	public UsuarioDetalhadoResponse getTodosUsuariosPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioController - getTodosUsuariosPorId");
		UsuarioDetalhadoResponse usuarioDetalhado = usuarioService.buscaUsuarioPorId(idUsuario);
		log.info("[finaliza] UsuarioController - getTodosUsuariosPorId");
		return usuarioDetalhado;
	}

	@Override
	public void AlteraUsuarioPorId(UUID idUsuario, @Valid UsuarioAlteracaoRequest usuarioAlteracaoResquest) {
		log.info("[inicia] UsuarioController - AlteraUsuarioPorId");
		log.info("[IdUsuario] {}", idUsuario);
		usuarioService.alteraUsuarioPorId(idUsuario, usuarioAlteracaoResquest);
		log.info("[finaliza] UsuarioController - AlteraUsuarioPorId");
		
	}

	@Override
	public void deletaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioController - AlteraUsuarioPorId");
		log.info("[finaliza] UsuarioController - AlteraUsuarioPorId");
		
	}

}
