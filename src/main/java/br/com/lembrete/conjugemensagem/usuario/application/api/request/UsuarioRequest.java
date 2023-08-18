package br.com.lembrete.conjugemensagem.usuario.application.api.request;

import java.time.LocalDate;

import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class UsuarioRequest {
	@NotBlank
	private String nomeUsuario;
	@NotBlank
	String documento;
	@NotNull
	private Sexo sexo;
	@NotBlank
	private String celular;
	@NotNull
	private LocalDate dataNascimento;
}
