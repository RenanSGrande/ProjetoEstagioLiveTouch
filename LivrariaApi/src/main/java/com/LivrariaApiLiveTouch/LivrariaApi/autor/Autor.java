package com.LivrariaApiLiveTouch.LivrariaApi.autor;

import com.LivrariaApiLiveTouch.LivrariaApi.livro.Livro;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "AUT_NOME")
	private String nome;

	@Column(name = "AUT_DATA_NASC")
	private String dataNasc;
	
	@Column(name = "AUT_PAIS")
	private String paisOrigem;

	@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
	private List<Livro> livrosAutor;

	public Autor (AutorDTO a) {
		this.id = a.getId();
		this.nome = a.getNome();
		this.dataNasc = a.getDataNasc();
		this.paisOrigem = a.getPaisOrigem();
	}

}
