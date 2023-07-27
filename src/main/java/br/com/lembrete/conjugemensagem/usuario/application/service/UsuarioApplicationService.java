package br.com.lembrete.conjugemensagem.usuario.application.service;

import org.springframework.stereotype.Service;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
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
}