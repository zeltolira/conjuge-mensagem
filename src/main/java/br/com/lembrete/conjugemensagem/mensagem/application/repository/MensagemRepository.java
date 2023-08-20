package br.com.lembrete.conjugemensagem.mensagem.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;

public interface MensagemRepository {
		Mensagem salvaMensagem(Mensagem mensagem);
		List<Mensagem> buscaTodasMensagens(Conjuge conjuge);
		Mensagem buscaMensagemPorId(Long idMensagem);
		void deletaMensagem(Long idMensagem);
}
