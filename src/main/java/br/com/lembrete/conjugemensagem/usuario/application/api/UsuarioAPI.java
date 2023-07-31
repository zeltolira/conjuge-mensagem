package br.com.lembrete.conjugemensagem.usuario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioAlteracaoRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioDetalhadoResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioListResponse;
import br.com.lembrete.conjugemensagem.usuario.application.api.response.UsuarioResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/usuario")
public interface UsuarioAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	UsuarioResponse postConjuge(@Valid @RequestBody UsuarioRequest usuarioRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<UsuarioListResponse> getTodosUsuario();
	
	@GetMapping(value = "/{idUsuario}")
	@ResponseStatus(code = HttpStatus.OK)
	UsuarioDetalhadoResponse getTodosUsuariosPorId(@PathVariable UUID idUsuario);
	
	@PatchMapping(value = "/{idUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void AlteraUsuarioPorId(@PathVariable UUID idUsuario, @Valid @RequestBody UsuarioAlteracaoRequest usuarioAlteracaoResquest);
}
