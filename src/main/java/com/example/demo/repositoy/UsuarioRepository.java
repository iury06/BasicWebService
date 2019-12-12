package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long >{

}
