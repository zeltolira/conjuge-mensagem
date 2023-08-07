package br.com.lembrete.conjugemensagem.mensagem.Application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lembrete.conjugemensagem.mensagem.Application.api.request.MensagemRequest;
import br.com.lembrete.conjugemensagem.mensagem.Application.api.response.MensagemResponse;

@RestController
@RequestMapping(value = "/v1/usuario/{idUsuario}/conjuge{idConjuge}/mensagem")
public interface mensagemAPI {

	MensagemResponse postMensagem(@PathVariable UUID idConjuge, MensagemRequest mensagemRequest);
}
