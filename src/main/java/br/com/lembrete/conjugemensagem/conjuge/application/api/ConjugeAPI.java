package br.com.lembrete.conjugemensagem.conjuge.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeAlteracaoRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeDetalhadoResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeListResponse;
import br.com.lembrete.conjugemensagem.conjuge.application.api.response.ConjugeResponse;
import jakarta.validation.Valid;

@RequestMapping(value = "/v1/conjuge/{idUsuario}")
public interface ConjugeAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ConjugeResponse postConjuge(@RequestParam UUID idUsuario, @Valid @RequestBody ConjugeRequest conjugeRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ConjugeListResponse> getTodosConjuges();
	
	@GetMapping(value = "/{idConjuge}")
	@ResponseStatus(code = HttpStatus.OK)
	ConjugeDetalhadoResponse getConjugePorId(@PathVariable UUID idConjuge);
	
	@PatchMapping(value = "/{idConjuge}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void PatchConjuge(@PathVariable UUID idUsuario, @Valid @RequestBody ConjugeAlteracaoRequest conjugeAlteracaoRequest);
	
	@DeleteMapping(value = "/{idConjuge}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void DeleteConjugePorId(@PathVariable UUID idConjuge);
}