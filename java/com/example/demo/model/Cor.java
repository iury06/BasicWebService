package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cor")
public class Cor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "cor_id")
	private int id;
	
	@Column(name = "cor_nome")
	private String nome;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
