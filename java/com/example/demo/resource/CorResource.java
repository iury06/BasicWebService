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

import com.example.demo.model.Cor;
import com.example.demo.repositoy.CorRepository;


@RestController
@RequestMapping("/cor")
public class CorResource {

	@Autowired 
	private  CorRepository corRepository;
	
	@GetMapping
	public List<Cor> list() {
		return corRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Cor> findById(@PathVariable Long id){
		return corRepository.findById(id);
		
	}

	@PostMapping
	public ResponseEntity<Cor> create (@RequestBody Cor cor, HttpServletResponse response){
		Cor save = corRepository.save(cor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		corRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cor> update(@PathVariable Long id, @RequestBody Cor ferramentas){
		Optional<Cor> corBanco = corRepository.findById(id);
		BeanUtils.copyProperties(ferramentas, corBanco.get());
		corRepository.save(corBanco.get());
		return ResponseEntity.ok(ferramentas);
	}

}
