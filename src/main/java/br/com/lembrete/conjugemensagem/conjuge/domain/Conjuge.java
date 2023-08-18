package br.com.lembrete.conjugemensagem.conjuge.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeAlteracaoRequest;
import br.com.lembrete.conjugemensagem.conjuge.application.api.request.ConjugeRequest;
import br.com.lembrete.conjugemensagem.mensagem.domain.Mensagem;
import br.com.lembrete.conjugemensagem.usuario.domain.Sexo;
import br.com.lembrete.conjugemensagem.usuario.domain.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
public class Conjuge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idConjuge;
	@NotBlank
	private String nomeConjuge;
	@NotBlank
	@Column(unique = true)
	String documento;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@NotBlank
	private String celular;
	@NotNull
	private LocalDate dataNascimento;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	
	@OneToOne(mappedBy = "conjuge")
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "conjuge", fetch = FetchType.LAZY)
	private List<Mensagem> mensagem;

	public Conjuge(Usuario usuario, ConjugeRequest conjugeRequest) {
		this.nomeConjuge = conjugeRequest.getNomeConjuge();
		this.documento = conjugeRequest.getDocumento();
		this.sexo = conjugeRequest.getSexo();
		this.celular = conjugeRequest.getCelular();
		this.dataNascimento = conjugeRequest.getDataNascimento();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
		this.usuario = usuario;
	}

	public void altera(@Valid ConjugeAlteracaoRequest conjugeRequest) {
		this.nomeConjuge = conjugeRequest.getNomeConjuge();
		this.sexo = conjugeRequest.getSexo();
		this.celular = conjugeRequest.getCelular();
		this.dataNascimento = conjugeRequest.getDataNascimento();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}
}