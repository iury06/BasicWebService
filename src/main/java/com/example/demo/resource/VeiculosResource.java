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

import com.example.demo.model.Veiculos;
import com.example.demo.repositoy.VeiculosRepository;



@RestController
@RequestMapping("/veiculos")
public class VeiculosResource {
		
			@Autowired 
			private VeiculosRepository veiculosRepository;
			
			@GetMapping
			public List<Veiculos> list() {
				return veiculosRepository.findAll();
				
			}
			
			@GetMapping("/{id}")
			public Optional<Veiculos> findById(@PathVariable Long id){
				return veiculosRepository.findById(id);
				
			}

			@PostMapping
			public ResponseEntity<Veiculos> create (@RequestBody Veiculos veiculos, HttpServletResponse response){
				Veiculos save = veiculosRepository.save(veiculos);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
				
				return ResponseEntity.created(uri).body(save);
			}
			@DeleteMapping("/{id}")
			@ResponseStatus(HttpStatus.NO_CONTENT)
			public void delete(@PathVariable Long id) {
				veiculosRepository.deleteById(id);
				
			}
			
			@PutMapping("/{id}")
			public ResponseEntity<Veiculos> update(@PathVariable Long id, @RequestBody Veiculos veiculos){
				Optional<Veiculos> veiculoBanco = veiculosRepository.findById(id);
				BeanUtils.copyProperties(veiculos, veiculoBanco.get());
				veiculosRepository.save(veiculoBanco.get());
				return ResponseEntity.ok(veiculos);
			}
	}


