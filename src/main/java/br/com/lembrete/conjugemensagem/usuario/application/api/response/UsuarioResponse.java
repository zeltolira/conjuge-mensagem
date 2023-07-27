package br.com.lembrete.conjugemensagem.usuario.application.api.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UsuarioResponse {
	private UUID idUsuario;
}
