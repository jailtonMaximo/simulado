package br.com.simulado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulado.modelos.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long>{

}
