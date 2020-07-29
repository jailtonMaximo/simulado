package br.com.simulado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulado.modelos.Banca;

public interface BancaRepository extends JpaRepository<Banca, Long>{

}
