package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "usuario")
public class Usuario {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			
			@Column(name = "id")
			private long id;
			
			@Column(name = "login")
			private String login;
			
			@Column(name = "senha")
			private String senha;

			

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getLogin() {
				return login;
			}

			public void setLogin(String login) {
				this.login = login;
			}

			public String getSenha() {
				return senha;
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}	
		
	}
