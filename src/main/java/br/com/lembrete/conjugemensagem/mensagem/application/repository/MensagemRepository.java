package br.com.lembrete.conjugemensagem.mensagem.application.repository;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;

public interface MensagemRepository {
		Mensagem salvaMensagem(Mensagem mensagem);
}
