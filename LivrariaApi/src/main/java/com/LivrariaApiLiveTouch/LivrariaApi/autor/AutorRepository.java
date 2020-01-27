package com.LivrariaApiLiveTouch.LivrariaApi.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LivrariaApiLiveTouch.LivrariaApi.autor.Autor;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findById(long id);

}
