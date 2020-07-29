package br.com.simulado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.modelos.Materia;
import br.com.simulado.repositorios.MateriaRepository;

@Service
public class MateriaServico {
	
	@Autowired
	MateriaRepository materiaRepository;
	
	public Optional<Materia> buscarUm(Long id) {
		
		 Optional<Materia> materia = materiaRepository.findById(id);
		 
		return materia;
	}

	public List<Materia> buscarTodos() {
		
		List<Materia> materias =	materiaRepository.findAll();
		
		return materias;
	}


	public void delete(Materia materia) {

		materiaRepository.delete(materia);
		
	}

	public Materia novo(Materia materia) {
		return materiaRepository.saveAndFlush(materia);

	}

}
