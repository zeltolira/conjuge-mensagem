package br.com.lembrete.conjugemensagem.usuario.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;

public interface UsuarioRepository {
	Usuario salva(Usuario usuario);
	List<Usuario> buscaTodosUsuarios();
	Usuario buscaUsuarioPorId(UUID idUsuario);
	void deletaUsuario(Usuario usuario);
}
