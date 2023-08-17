package br.com.lembrete.conjugemensagem.mensagem.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.lembrete.conjugemensagem.conjuge.domain.Conjuge;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemAlteracaoRequest;
import br.com.lembrete.conjugemensagem.mensagem.application.api.request.MensagemRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "mensagem")
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idMensagem;
	@NotBlank
	private String mensagemAReceber;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;

	@ManyToOne
	@JoinColumn(name = "idConjuge")
	private Conjuge conjuge;
	
	public Mensagem(UUID idConjuge, MensagemRequest mensagemRequest) {
		this.mensagemAReceber = mensagemRequest.getMensagemAReceber();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}

	public void altera(@Valid MensagemAlteracaoRequest mensagemRequest) {
		this.mensagemAReceber = mensagemRequest.getMensagemAReceber();
		this.dataHoraUltimaAlteracao = LocalDateTime.now();
	}
}