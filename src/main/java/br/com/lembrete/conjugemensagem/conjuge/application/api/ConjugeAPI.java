package br.com.lembrete.conjugemensagem.conjuge.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/usuario/{idUsuario}/conjuge")
public interface ConjugeAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ConjugeResponse postConjuge(@PathVariable UUID idUsuario, @Valid @RequestBody ConjugeRequest conjugeRequest);
	
}
