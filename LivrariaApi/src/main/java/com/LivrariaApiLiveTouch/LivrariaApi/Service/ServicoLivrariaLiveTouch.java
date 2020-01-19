package com.LivrariaApiLiveTouch.LivrariaApi.Service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LivrariaApiLiveTouch.LivrariaApi.Service.Exception.LivrariaLiveTouchException;
import com.LivrariaApiLiveTouch.LivrariaApi.model.Autor;
import com.LivrariaApiLiveTouch.LivrariaApi.model.Livro;
import com.LivrariaApiLiveTouch.LivrariaApi.repository.AutorRepository;
import com.LivrariaApiLiveTouch.LivrariaApi.repository.LivroRepository;

@Service
public class ServicoLivrariaLiveTouch {

	@Autowired
	LivroRepository livroRepository;
	@Autowired
	AutorRepository autoRepository;

	public List<Livro> buscarTodosLivros() {
		return livroRepository.findAll();
	}

	public Livro buscarLivroPorID(long id) throws LivrariaLiveTouchException {
		if (id < 1) {
			throw new LivrariaLiveTouchException("ID INVÁLIDO");
		} else {
			return livroRepository.findById(id);
		}
	}

	public Livro salvarLivro(Livro livro) throws LivrariaLiveTouchException {
		if (testaLivro(livro)) {
			throw new LivrariaLiveTouchException("TODOS OS PARAMETROS DEVEM SER PREENCHIDOS");
		} else {
			if (livro.getAutor().getId() < 1) {
				throw new LivrariaLiveTouchException("ID INVÁLIDO");
			}
			Autor autor = buscarAutorPorID(livro.getAutor().getId());
			livro.setAutor(autor);
			Livro livroSalvo = this.livroRepository.save(livro);
			autor.getLivrosAutor().add(livroSalvo);
			salvarAutorInterno(autor);
			return livroSalvo;
		}
	}

	public Livro modificarLivro(Livro livro) throws LivrariaLiveTouchException {
		if (livro.getId() < 1) {
			throw new LivrariaLiveTouchException("INFORMAR ID DO LIVRO PARA ATUALIZAÇÃO");
		}
		Autor autorBD = buscarLivroPorID(livro.getId()).getAutor();
		if (livro.getAutor().equals(autorBD)) {
			return this.livroRepository.save(livro);
		} else {
			Livro livroSalvo = this.livroRepository.save(livro);
			autorBD.getLivrosAutor().remove(livroSalvo);
			salvarAutorInterno(autorBD);
			livroSalvo.getAutor().getLivrosAutor().add(livroSalvo);
			salvarAutorInterno(livroSalvo.getAutor());
			return livroSalvo;
		}

	}

	public void deletarLivroPorID(long id) throws LivrariaLiveTouchException {
		Livro livro = buscarLivroPorID(id);
		livro.getAutor().getLivrosAutor().remove(livro);
		salvarAutor(livro.getAutor());
		this.livroRepository.deleteById(id);
	}

	public Autor salvarAutor(Autor autor) throws LivrariaLiveTouchException {
		if (testaAutor(autor)) {
			throw new LivrariaLiveTouchException("TODOS OS PARAMETROS DEVEM SER PREENCHIDOS");
		} else if (autor.getLivrosAutor() != null && !autor.getLivrosAutor().isEmpty()) {
			throw new LivrariaLiveTouchException("PARA ADICIONAR LIVROS AO AUTOR USAR: CADASTRAR LIVRO");
		} else {
			return this.autoRepository.save(autor);
		}
	}

	private void salvarAutorInterno(Autor autor) throws LivrariaLiveTouchException {
		if (testaAutor(autor)) {
			throw new LivrariaLiveTouchException("TODOS OS PARAMETROS DEVEM SER PREENCHIDOS");
		} else {
			this.autoRepository.save(autor);
		}
	}

	public List<Autor> buscarTodosAutores() {
		return this.autoRepository.findAll();
	}

	public Autor buscarAutorPorID(long id) throws LivrariaLiveTouchException {
		if (id < 1) {
			throw new LivrariaLiveTouchException("INFORMAR ID DO LIVRO PARA ATUALIZAÇÃO");
		}
		return this.autoRepository.findById(id);
	}

	private boolean testaLivro(Livro livro) {
		return StringUtils.isBlank(livro.getCodigoISBN()) || StringUtils.isBlank(livro.getDataPublicacao())
				|| StringUtils.isBlank(livro.getEdicao()) || StringUtils.isBlank(livro.getTitulo())
				|| livro.getAutor() == null;
	}

	private boolean testaAutor(Autor autor) {
		return StringUtils.isBlank(autor.getDataNasc()) || StringUtils.isBlank(autor.getNome())
				|| StringUtils.isBlank(autor.getPaisOrigem());
	}

}
