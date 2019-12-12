package com.example.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Marca;
import com.example.demo.repositoy.MarcaRepository;

@RestController
@RequestMapping("/marca")
public class MarcaResource {

	@Autowired 
	private  MarcaRepository marcaRepository;
	
	@GetMapping
	public List<Marca> list() {
		return marcaRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Marca> findById(@PathVariable Long id){
		return marcaRepository.findById(id);
		
	}

	@PostMapping
	public ResponseEntity<Marca> create (@RequestBody Marca marca, HttpServletResponse response){
		Marca save = marcaRepository.save(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		marcaRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Marca> update(@PathVariable Long id, @RequestBody Marca marca){
		Optional<Marca> MarcaBanco = marcaRepository.findById(id);
		BeanUtils.copyProperties(marca, MarcaBanco.get());
		marcaRepository.save(MarcaBanco.get());
		return ResponseEntity.ok(marca);
	}

}

