package br.com.lembrete.conjugemensagem.usuario.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "conjuge")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idConjuge;
	@NotBlank
	private String nomeConjuge;
	@NotNull
	private Sexo sexo;
	@NotBlank
	private String celular;
	@NotNull
	private LocalDate dataNascimento;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	public Usuario(UUID idConjuge, @NotBlank String nomeConjuge, @NotNull Sexo sexo, @NotBlank String celular,
			@NotNull LocalDate dataNascimento, LocalDateTime dataHoraUltimaAlteracao) {
		this.idConjuge = idConjuge;
		this.nomeConjuge = nomeConjuge;
		this.sexo = sexo;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
		this.dataHoraDoCadastro = LocalDateTime.now();
	}
	
	
}
