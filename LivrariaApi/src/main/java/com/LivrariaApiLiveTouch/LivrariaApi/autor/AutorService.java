package com.LivrariaApiLiveTouch.LivrariaApi.autor;

import com.LivrariaApiLiveTouch.LivrariaApi.exception.BadRequestException;
import com.LivrariaApiLiveTouch.LivrariaApi.livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroService livroService;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public List<AutorDTO> findAllAutores() {
        return findAll().stream().map(AutorDTO::new).collect(Collectors.toList());
    }

    public Optional<Autor> findById(Long id){
        return autorRepository.findById(id);
    }

    public AutorDTO buscarAutorPorId(Long id) {
        return findById(id).map(AutorDTO::new)
                .orElseThrow(() -> new BadRequestException("Autor não encontrado"));
    }

    public AutorDTO save(AutorDTO a) {
        return new AutorDTO(autorRepository.save(new Autor(a)));
    }

    public void delete(Long id) {
        Optional<Autor> aOPT = findById(id);
        if(!aOPT.isPresent())
            throw new BadRequestException("Autor não encontrado");

        autorRepository.delete(aOPT.get());
    }

    public AutorDTO update(Long id, AutorDTO autorDTO) {
        return findById(id).map(autor -> {
            autor.setDataNasc(autorDTO.getDataNasc());
            autor.setNome(autorDTO.getNome());
            autor.setPaisOrigem(autorDTO.getPaisOrigem());
            autorRepository.save(autor);

            return new AutorDTO(autor);
        }).orElseThrow(() -> new BadRequestException("Autor não encontrado"));
    }

}
