package br.com.lembrete.conjugemensagem.usuario.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioAlteracaoRequest;
import br.com.lembrete.conjugemensagem.usuario.application.api.request.UsuarioRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUsuario;
	@NotBlank
	private String nomeUsuario;
	@NotNull
	private Sexo sexo;
	@NotBlank
	private String celular;
	@NotNull
	private LocalDate dataNascimento;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = fk_id_conjuge)
//	private Conjuge conjuge;
	
	
	public Usuario(UsuarioRequest usuarioRequest) {
		this.nomeUsuario = usuarioRequest.getNomeUsuario();
		this.sexo = usuarioRequest.getSexo();
		this.celular = usuarioRequest.getCelular();
		this.dataNascimento = usuarioRequest.getDataNascimento();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}


	public void altera(UsuarioAlteracaoRequest usuarioRequest) {
		this.nomeUsuario = usuarioRequest.getNomeUsuario();
		this.sexo = usuarioRequest.getSexo();
		this.celular = usuarioRequest.getCelular();
		this.dataNascimento = usuarioRequest.getDataNascimento();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
		
	}

}