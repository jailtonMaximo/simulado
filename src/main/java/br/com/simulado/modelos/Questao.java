package br.com.simulado.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@Entity
@Table(name = "questao")
public class Questao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "pergunta")
	private String pergunta;
	
	@Column(name = "tipo")
	private Boolean tipo;
	
	@Column(name = "banca")
	private Banca banca;
	
	@Column(name = "materia")
	private Materia materia;
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties({"alternativa"})	
	@OneToMany(mappedBy="questao",fetch=FetchType.LAZY,orphanRemoval=true)
	@Cascade(value={CascadeType.ALL})
	private List<Alternativa> alternativas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Boolean isTipo() {
		return tipo;
	}

	public void isTipo(Boolean tipo) {
		this.tipo = tipo;
	}

}
