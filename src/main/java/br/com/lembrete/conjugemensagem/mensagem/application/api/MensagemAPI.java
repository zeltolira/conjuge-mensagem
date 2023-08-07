package br.com.lembrete.conjugemensagem.mensagem.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/usuario/{idUsuario}/conjuge{idConjuge}/mensagem")
public interface MensagemAPI {

}
