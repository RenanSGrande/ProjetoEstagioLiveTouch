package com.LivrariaApiLiveTouch.LivrariaApi.autor;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {

    private Long id;
    @NotNull(message = "O campo nome é necessário")
    private String nome;
    @NotNull(message = "O campo dataNasc é necessário")
    private String dataNasc;
    @NotNull(message = "O campo paisOrigem é necessário")
    private String paisOrigem;

    public AutorDTO (Autor a) {
        this.id = a.getId();
        this.nome = a.getNome();
        this.dataNasc = a.getDataNasc();
        this.paisOrigem = a.getPaisOrigem();
    }

}
