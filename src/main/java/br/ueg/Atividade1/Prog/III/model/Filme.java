package br.ueg.Atividade1.Prog.III.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_filme")
public @Data class Filme {
	
	@Id
	@SequenceGenerator(
			name = "filme_sequence",
			sequenceName = "filme_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "filme_sequence"
			)
	private Long idFilme;
	
	@Column(name = "c_titulo", nullable = false, unique = true)
	private String titulo;
	
	@Column(name = "c_diretor", nullable = false)
	private String diretor;
	
	@Column(name = "c_data", nullable = false)
	private String dataLancamento;
	
	@Column(name = "c_duracao", nullable = false)
	private Integer duracao;
}
