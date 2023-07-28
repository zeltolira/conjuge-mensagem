package br.com.lembrete.conjugemensagem.usuario.application.service;

import java.util.List;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioListResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import jakarta.validation.Valid;

public interface UsuarioService {
	UsuarioResponse criaConjuge(@Valid UsuarioRequest usuarioRequest);
	List<UsuarioListResponse> buscaTodosUsuario();
}
