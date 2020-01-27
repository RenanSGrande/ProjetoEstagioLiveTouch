package com.LivrariaApiLiveTouch.LivrariaApi.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(autorService.findAllAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarAutorPorId(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AutorDTO autor) {
        return ResponseEntity.ok(autorService.save(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody AutorDTO autor) {
        return ResponseEntity.ok(autorService.update(id, autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        autorService.delete(id);
        return ResponseEntity.ok().build();
    }

}
