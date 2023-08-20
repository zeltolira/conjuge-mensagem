package br.com.lembrete.conjugemensagem.mensagem.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemDetalhadaResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemListResponse;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/mensagem/{idUsuario}")
public interface MensagemAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	MensagemResponse postMensagem(@RequestParam UUID idUsuario,@Valid @RequestBody MensagemRequest mensagemRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<MensagemListResponse> getTodasMensagens(@RequestParam UUID idUsuario);
	
	@GetMapping(value = "/{idMensagem}")
	@ResponseStatus(code = HttpStatus.OK)
	MensagemDetalhadaResponse getMensagemPorId(@RequestParam UUID idUsuario, @PathVariable Long idMensagem);
	
	@PatchMapping(value = "/{idMensagem}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void PatchMensagem(@PathVariable Long idMensagem, @Valid @RequestBody MensagemAlteracaoRequest mensagemAlteracaoRequest);
	
	@DeleteMapping(value = "/{idMensagem}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaMensagemPorId(@PathVariable Long idMensagem);
	
	
}