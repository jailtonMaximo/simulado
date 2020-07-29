package br.com.simulado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulado.modelos.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
