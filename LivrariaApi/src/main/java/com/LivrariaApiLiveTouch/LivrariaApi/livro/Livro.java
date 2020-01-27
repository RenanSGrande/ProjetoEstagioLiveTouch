package com.LivrariaApiLiveTouch.LivrariaApi.livro;

import javax.persistence.*;

import com.LivrariaApiLiveTouch.LivrariaApi.autor.Autor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "LIV_TITULO")
	private String titulo;

	@JsonIgnoreProperties("livrosAutor")
	@ManyToOne(fetch = FetchType.EAGER)
	private Autor autor;

	@Column(name = "LIV_DATA_PUBLIC")
	private String dataPublicacao;

	@Column(name = "LIV_EDICAO")
	private String edicao;

	@Column(name = "LIV_COD_ISBN")
	private String codigoISBN;

	@Column(name = "LIV_DESC", length = 1000)
	private String descricao;

	public Livro(LivroDTO l) {
		this.id = l.getId();
		this.titulo = l.getTitulo();
		this.autor = new Autor(l.getAutor());
		this.dataPublicacao = l.getDataPublicacao();
		this.edicao = l.getEdicao();
		this.codigoISBN = l.getCodigoISBN();
		this.descricao = l.getDescricao();
	}

}
// um título, apenas um autor, data de publicação, edição e código ISBN
