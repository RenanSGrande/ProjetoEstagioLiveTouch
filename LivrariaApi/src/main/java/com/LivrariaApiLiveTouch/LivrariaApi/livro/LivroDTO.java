package com.LivrariaApiLiveTouch.LivrariaApi.livro;

import com.LivrariaApiLiveTouch.LivrariaApi.autor.Autor;
import com.LivrariaApiLiveTouch.LivrariaApi.autor.AutorDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long id;
    @NotNull(message = "O campo título é necessário")
    private String titulo;
    @NotNull(message = "O campo autor é necessário")
    private AutorDTO autor;
    @NotNull(message = "O campo dataPublicação é necessário")
    private String dataPublicacao;
    @NotNull(message = "O campo edição é necessário")
    private String edicao;
    @NotNull(message = "O campo codigoISBN é necessário")
    private String codigoISBN;
    private String descricao;

    public LivroDTO(Livro l) {
        this.id = l.getId();
        this.titulo = l.getTitulo();
        this.autor = new AutorDTO(l.getAutor());
        this.dataPublicacao = l.getDataPublicacao();
        this.edicao = l.getEdicao();
        this.codigoISBN = l.getCodigoISBN();
        this.descricao = l.getDescricao();
    }

}
