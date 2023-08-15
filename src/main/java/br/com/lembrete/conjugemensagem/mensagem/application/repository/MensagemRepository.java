package br.com.lembrete.conjugemensagem.mensagem.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;

public interface MensagemRepository {
		Mensagem salvaMensagem(Mensagem mensagem);
		List<Mensagem> buscaTodasMensagens();
		Mensagem buscaMensagemPorId(UUID idConjuge, UUID idMensagem);
		void deletaMensagem(Mensagem mensagem);
		Mensagem buscaMensagemAleatoria(UUID idConjuge);
}
