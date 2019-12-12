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
import com.example.demo.model.Veiculo;
import com.example.demo.repositoy.ModeloRepositoy;
import com.example.demo.repositoy.VeiculoRepository;

@RestController
@RequestMapping("/Veiculo")

public class VeiculoResource {
	
		@Autowired 
		private VeiculoRepository veiculoRepository;
		
		@GetMapping
		public List<Veiculo> list() {
			return veiculoRepository.findAll();
			
		}
		
		@GetMapping("/{id}")
		public Optional<Veiculo> findById(@PathVariable Long id){
			return veiculoRepository.findById(id);
			
		}

		@PostMapping
		public ResponseEntity<Veiculo> create (@RequestBody Veiculo veiculo, HttpServletResponse response){
			Veiculo save = veiculoRepository.save(veiculo);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
			
			return ResponseEntity.created(uri).body(save);
		}
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			veiculoRepository.deleteById(id);
			
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo){
			Optional<Veiculo> veiculoBanco = veiculoRepository.findById(id);
			BeanUtils.copyProperties(veiculo, veiculoBanco.get());
			veiculoRepository.save(veiculoBanco.get());
			return ResponseEntity.ok(veiculo);
		}

	}


