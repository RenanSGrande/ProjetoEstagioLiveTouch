package com.LivrariaApiLiveTouch.LivrariaApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_Livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "LIV_TITULO")
	private String titulo;

	@JsonIgnoreProperties("livrosAutor")
	@ManyToOne
	private Autor autor;

	@Column(name = "LIV_DATA_PUBLIC")
	private String dataPublicacao;

	@Column(name = "LIV_EDICAO")
	private String edicao;

	@Column(name = "LIV_COD_ISBN")
	private String codigoISBN;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(String codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public long getId() {
		return id;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
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
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
// um título, apenas um autor, data de publicação, edição e código ISBN