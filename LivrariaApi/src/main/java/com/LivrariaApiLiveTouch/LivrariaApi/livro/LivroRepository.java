package com.LivrariaApiLiveTouch.LivrariaApi.livro;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LivrariaApiLiveTouch.LivrariaApi.livro.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	Optional<Livro> findById(Long id);

	List<Livro> findAllByAutorId(Long id);

}
