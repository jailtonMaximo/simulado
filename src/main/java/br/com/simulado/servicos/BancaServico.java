package br.com.simulado.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simulado.modelos.Banca;
import br.com.simulado.repositorios.BancaRepository;

@Service
public class BancaServico {

	@Autowired
	BancaRepository bancaRepository;
	
	public Optional<Banca> buscarUm(Long id) {
	return  bancaRepository.findById(id);
	}

	public List<Banca> buscarTodos() {
		List<Banca> bancas = new ArrayList<Banca>();
		bancas = bancaRepository.findAll();
		return bancas;
	}

	public void novo(Banca banca) {
		bancaRepository.saveAndFlush(banca);
		
	}

	public void delete(BancaServico bancaServico) {
		// TODO Auto-generated method stub
		
	}

}
