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

import com.example.demo.model.Modelo;
import com.example.demo.repositoy.ModeloRepositoy;

@RestController
@RequestMapping("/modelo")

public class ModeloResource {
	
		@Autowired 
		private ModeloRepositoy modeloRepository;
		
		@GetMapping
		public List<Modelo> list() {
			return modeloRepository.findAll();
			
		}
		
		@GetMapping("/{id}")
		public Optional<Modelo> findById(@PathVariable Long id){
			return modeloRepository.findById(id);
			
		}

		@PostMapping
		public ResponseEntity<Modelo> create (@RequestBody Modelo modelo, HttpServletResponse response){
			Modelo save = modeloRepository.save(modelo);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
			
			return ResponseEntity.created(uri).body(save);
		}
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			modeloRepository.deleteById(id);
			
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Modelo> update(@PathVariable Long id, @RequestBody Modelo modelo){
			Optional<Modelo> modeloBanco = modeloRepository.findById(id);
			BeanUtils.copyProperties(modelo, modeloBanco.get());
			modeloRepository.save(modeloBanco.get());
			return ResponseEntity.ok(modelo);
		}

	}

