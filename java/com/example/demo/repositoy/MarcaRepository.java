package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca,Long > {

	
}
