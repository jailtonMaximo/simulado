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

import br.com.simulado.modelos.Banca;
import br.com.simulado.servicos.BancaServico;

@RestController
@RequestMapping("/api/banca")
public class BancaControler  {
	
	@Autowired
	BancaServico bancaServico;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> banca(@PathVariable("id") Long id){
		
		 Optional<Banca> banca = bancaServico.buscarUm(id);
		 if(banca.isPresent()) {
			 return ResponseEntity.ok().body(banca);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
		
		
	} 
	
	@GetMapping
	public ResponseEntity<?> bancas(){
		 List<Banca> bancas = bancaServico.buscarTodos();
		 
		 if(!bancas.isEmpty()) {
			 return ResponseEntity.ok().body(bancas);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		Optional<Banca> banca = bancaServico.buscarUm(id);
		 if(banca.isPresent()) {
			 
			 bancaServico.delete(bancaServico);
				return ResponseEntity.ok().build();
		 }else {
		return ResponseEntity.ok().build();
		 }
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id){
		
		return ResponseEntity.ok().build();
		
	} 
	
	@PostMapping
	public ResponseEntity<?> novo(@RequestBody Banca banca) {
		
		bancaServico.novo(banca);
		
		return ResponseEntity.ok().build();
		
	} 
	
	
}
