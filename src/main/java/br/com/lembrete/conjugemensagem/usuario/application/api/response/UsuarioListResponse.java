package br.com.lembrete.conjugemensagem.usuario.application.api.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;
import lombok.Value;

@Value
public class UsuarioListResponse {
	private UUID idUsuario;
	private String nomeUsuario;
	String documento;
	private Sexo sexo;
	private String celular;
	private LocalDate dataNascimento;
	
	
	public static List<UsuarioListResponse> converte(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(UsuarioListResponse::new)
				.collect(Collectors.toList());
	}


	public UsuarioListResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.documento = usuario.getDocumento();
		this.sexo = usuario.getSexo();
		this.celular = usuario.getCelular();
		this.dataNascimento = usuario.getDataNascimento();
	}
	
	
}
