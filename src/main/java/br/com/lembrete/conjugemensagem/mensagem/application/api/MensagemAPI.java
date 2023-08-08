package br.com.lembrete.conjugemensagem.mensagem.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.response.MensagemResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/usuario/{idUsuario}/conjuge/{idConjuge}/mensagem")
public interface MensagemAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	MensagemResponse postMensagem(@PathVariable UUID idConjuge,@Valid @RequestBody MensagemRequest mensagemRequest);
}