package com.LivrariaApiLiveTouch.LivrariaApi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TB_Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "AUT_NOME")
	private String nome;

	
	@Column(name = "AUT_DATA_NASC")
	private String dataNasc;
	
	
	@Column(name = "AUT_PAIS")
	private String paisOrigem;

	@JsonIgnoreProperties("autor")
	@OneToMany
	private List<Livro> livrosAutor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public List<Livro> getLivrosAutor() {
		return livrosAutor;
	}

	public void setLivrosAutor(List<Livro> livrosAutor) {
		this.livrosAutor = livrosAutor;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
