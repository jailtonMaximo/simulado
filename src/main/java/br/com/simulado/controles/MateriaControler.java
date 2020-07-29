package br.com.simulado.controles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simulado.modelos.Materia;
import br.com.simulado.servicos.MateriaServico;

@RestController
@RequestMapping("/api/materia")
public class MateriaControler {

	@Autowired
	MateriaServico materiaServico;

	@GetMapping("/{id}")
	public ResponseEntity<?> materia(@PathVariable("id") Long id) {

		Optional<Materia> materia = materiaServico.buscarUm(id);

		if (materia.isPresent()) {

			return ResponseEntity.ok().body(materia);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

	@GetMapping
	public ResponseEntity<?> materias() {

		List<Materia> materias = materiaServico.buscarTodos();
		if (!materias.isEmpty()) {

			return ResponseEntity.ok().body(materias);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Optional<Materia> materia = materiaServico.buscarUm(id);
		if (materia.isPresent()) {

			materiaServico.delete(materia.get());

			return ResponseEntity.ok().build();

		} else {

			return ResponseEntity.ok().build();

		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id) {
		Optional<Materia> materia = materiaServico.buscarUm(id);
		
		if(materia.isPresent()) {
			materiaServico.delete(materia.get());
		}
		
		return ResponseEntity.ok().body(materia.get());

	}

	@PostMapping
	public ResponseEntity<?> novo(@RequestBody Materia materia) {
		Materia mat = materiaServico.novo(materia);
		return ResponseEntity.ok().body(mat);

	}
}
