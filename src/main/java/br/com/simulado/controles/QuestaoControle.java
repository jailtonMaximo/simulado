package br.com.simulado.controles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simulado.modelos.Questao;

@RestController
@RequestMapping("/api/questao")
public class QuestaoControle {

	@GetMapping("/{id}")
	public ResponseEntity<?> questao(@PathVariable("id") Long id) {

		return ResponseEntity.ok().build();

	}

	@GetMapping
	public ResponseEntity<?> questoes() {

		return ResponseEntity.ok().build();

	}

	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		return ResponseEntity.ok().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id) {

		return ResponseEntity.ok().build();

	}

	@PostMapping
	public ResponseEntity<?> novo(Questao questao) {

		return ResponseEntity.ok().build();

	}

}
