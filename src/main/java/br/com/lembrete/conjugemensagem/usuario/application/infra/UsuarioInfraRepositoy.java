package br.com.lembrete.conjugemensagem.usuario.application.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.lembrete.conjugemensagem.handler.APIException;
import br.com.lembrete.conjugemensagem.usuario.application.repository.UsuarioRepository;
import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepositoy implements UsuarioRepository {
	private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;

	@Override
	public Usuario salva(Usuario usuario) {
	log.info("[inicia] UsuarioInfraRepositoy - salva");
	usuarioSpringDataJPARepository.save(usuario);
	log.info("[finaliza] UsuarioInfraRepositoy - salva");
	return usuario;
	}

	@Override
	public List<Usuario> buscaTodosUsuarios() {
		log.info("[inicia] UsuarioInfraRepositoy - buscaTodosUsuarios");
		List<Usuario> todosUsuarios = usuarioSpringDataJPARepository.findAll();
		log.info("[finaliza] UsuarioInfraRepositoy - buscaTodosUsuarios");
		return todosUsuarios;
	}

	@Override
	public Usuario buscaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuarioInfraRepositoy - buscaUsuarioPorId");
		Usuario usuario = usuarioSpringDataJPARepository.findById(idUsuario)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuario não encontrado!"));
		log.info("[finaliza] UsuarioInfraRepositoy - buscaUsuarioPorId");
		return usuario;
	}

	@Override
	public void deletaUsuario(Usuario usuario) {
		log.info("[inicia] UsuarioInfraRepositoy - deletaUsuario");
		log.info("[finaliza] UsuarioInfraRepositoy - deletaUsuario");
		
	}
}