package br.com.lembrete.conjugemensagem.usuario.application.api.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import lombok.Value;

@Value
public class UsuarioDetalhadoResponse {
	private UUID idUsuario;
	private String nomeUsuario;
	private Sexo sexo;
	private String celular;
	private LocalDate dataNascimento;
	private LocalDateTime dataHoraUltimaAlteracao;
}
