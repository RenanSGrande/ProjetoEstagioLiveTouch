package com.LivrariaApiLiveTouch.LivrariaApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LivrariaApiLiveTouch.LivrariaApi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	public Autor findById(long id);
}
