package br.com.lembrete.conjugemensagem.usuario.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
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

}
