package com.LivrariaApiLiveTouch.LivrariaApi.livro;

import com.LivrariaApiLiveTouch.LivrariaApi.autor.Autor;
import com.LivrariaApiLiveTouch.LivrariaApi.autor.AutorService;
import com.LivrariaApiLiveTouch.LivrariaApi.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorService autorService;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public List<LivroDTO> findAllLivros() {
        return findAll().stream().map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<Livro> findById(Long id){
        return livroRepository.findById(id);
    }

    public LivroDTO buscarLivroPorID(Long id) {
        return findById(id).map(LivroDTO::new)
                .orElseThrow(() -> new BadRequestException("Livro não encontrado"));
    }

    public LivroDTO salvarLivro(LivroDTO livroDTO) {
        Livro livro = new Livro(livroDTO);
        if(Objects.isNull(livroDTO.getAutor().getId())) {
            livro.setAutor(new Autor(autorService.save(livroDTO.getAutor())));
        }
        return new LivroDTO(livroRepository.save(livro));
    }

    public LivroDTO modificarLivro(Long id, LivroDTO livro) {
        return livroRepository.findById(id).map(l -> {
           l.setAutor(new Autor(livro.getAutor()));
           l.setCodigoISBN(livro.getCodigoISBN());
           l.setDataPublicacao(livro.getDataPublicacao());
           l.setDescricao(livro.getDescricao());
           l.setEdicao(livro.getEdicao());
           l.setTitulo(livro.getTitulo());
           livroRepository.save(l);

           return new LivroDTO(l);
        }).orElseThrow(() -> new BadRequestException(""));
    }

    public void deletarLivroPorID(Long id) {
        Livro livro = findById(id)
                        .orElseThrow(() -> new BadRequestException("Erro ao deletar Livro")); //Alterar
        livroRepository.delete(livro);
    }

    public List<LivroDTO> findAllByLivroId(Long id) {
        return livroRepository.findAllByAutorId(id).stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
