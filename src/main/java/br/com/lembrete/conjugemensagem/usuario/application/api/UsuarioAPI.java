package br.com.lembrete.conjugemensagem.usuario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	UsuarioResponse postConjuge(@Valid @RequestBody UsuarioRequest conjugeRequeste);
}
