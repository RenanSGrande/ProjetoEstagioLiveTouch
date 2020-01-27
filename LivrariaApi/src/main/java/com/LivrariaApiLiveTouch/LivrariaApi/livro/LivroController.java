package com.LivrariaApiLiveTouch.LivrariaApi.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@GetMapping
	public ResponseEntity listarTodosLivros() {
		return ResponseEntity.ok(livroService.findAllLivros());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity listarLivroPorId(@PathVariable Long id) {
		return ResponseEntity.ok(livroService.buscarLivroPorID(id));
	}

	@PostMapping
	public ResponseEntity cadastrarLivro(@RequestBody LivroDTO livro) {
		return ResponseEntity.ok(livroService.salvarLivro(livro));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity atualizaLivro(@PathVariable Long id,
										@RequestBody LivroDTO livro) {
		return ResponseEntity.ok(livroService.modificarLivro(id, livro));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity removerLivroPorId(@PathVariable Long id) {
		livroService.deletarLivroPorID(id);
		return ResponseEntity.ok().build();
	}

}
