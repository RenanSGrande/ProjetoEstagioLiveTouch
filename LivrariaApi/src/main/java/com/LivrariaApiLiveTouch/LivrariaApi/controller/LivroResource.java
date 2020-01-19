package com.LivrariaApiLiveTouch.LivrariaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LivrariaApiLiveTouch.LivrariaApi.Service.ServicoLivrariaLiveTouch;
import com.LivrariaApiLiveTouch.LivrariaApi.Service.Exception.LivrariaLiveTouchException;
import com.LivrariaApiLiveTouch.LivrariaApi.model.Autor;
import com.LivrariaApiLiveTouch.LivrariaApi.model.Livro;

@RestController
@RequestMapping(value = "/api")
public class LivroResource {

	@Autowired
	ServicoLivrariaLiveTouch servico;

	@GetMapping(value = "/listarlivros")
	public List<Livro> listarTodosLivros() {
		return this.servico.buscarTodosLivros();
	}

	@GetMapping(value = "/listarlivro")
	public Livro listarLivroPorId(@RequestBody Livro livro) throws LivrariaLiveTouchException {
		return this.servico.buscarLivroPorID(livro.getId());
	}

	@PostMapping(value = "/cadastrarlivro")
	public Livro cadastrarLivro(@RequestBody Livro livro) throws LivrariaLiveTouchException {
		return this.servico.salvarLivro(livro);
	}

	@PutMapping(value = "/atualizarlivro")
	public Livro atualizaLivro(@RequestBody Livro livro) throws LivrariaLiveTouchException {
		return this.servico.modificarLivro(livro);
	}

	@DeleteMapping(value = "/removerlivro")
	public void removerLivroPorId(@RequestBody Livro livro) throws LivrariaLiveTouchException {
		this.servico.deletarLivroPorID(livro.getId());
	}

	@GetMapping(value = "/listarautores")
	public List<Autor> listarTodosAutores() {
		return this.servico.buscarTodosAutores();
	}

	@GetMapping(value = "/listarautor")
	public Autor listarAutorPorId(@RequestBody Autor autor) throws LivrariaLiveTouchException {
		return this.servico.buscarAutorPorID(autor.getId());
	}

	@PostMapping(value = "/cadastrarautor")
	public Autor cadastrarAutor(@RequestBody Autor autor) throws LivrariaLiveTouchException {
		return this.servico.salvarAutor(autor);
	}

}
