package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "modelo")
public class Modelo {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "mod_id")
		private int id;
		
		@Column(name = "mod_descricao")
		private String descricao;
		
		@ManyToOne @JoinColumn(name="mar_id")
		private Marca marca;


		public Marca getMarca() {
		return marca;
		}


		public void setMarca(Marca marca) {
		this.marca = marca;
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
