package br.com.lembrete.conjugemensagem.usuario.application.service;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioAlteracaoRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioDetalhadoResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioListResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import jakarta.validation.Valid;

public interface UsuarioService {
	UsuarioResponse criaConjuge(@Valid UsuarioRequest usuarioRequest);
	List<UsuarioListResponse> buscaTodosUsuario();
	UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario);
	void alteraUsuarioPorId(UUID idUsuario, UsuarioAlteracaoRequest usuarioAlteracaoResquest);
	void deleta(UUID idUsuario);
}
