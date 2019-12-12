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
@Table(name= "Veiculo")
public class Veiculo {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "veicu_id")
		private int id;
		
		@Column(name = "veicu_renavam")
		private String renavam;
		
		@Column(name = "veicu_chassi")
		private int chassi;
		
		@Column(name = "veicu_descricao")
		private int descricao;
		
		@Column(name = "veicu_anoFab")
		private int anoFab;
		
		@Column(name = "veicu_anoMod")
		private int anoMod;
		
		
		@ManyToOne @JoinColumn(name="mod_id")
		private Modelo modelo; 

		@ManyToOne @JoinColumn(name="cor_id")
		private Cor cor;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRenavam() {
			return renavam;
		}

		public void setRenavam(String renavam) {
			this.renavam = renavam;
		}

		public int getChassi() {
			return chassi;
		}

		public void setChassi(int chassi) {
			this.chassi = chassi;
		}

		public int getDescricao() {
			return descricao;
		}

		public void setDescricao(int descricao) {
			this.descricao = descricao;
		}

		public int getAnoFab() {
			return anoFab;
		}

		public void setAnoFab(int anoFab) {
			this.anoFab = anoFab;
		}

		public int getAnoMod() {
			return anoMod;
		}

		public void setAnoMod(int anoMod) {
			this.anoMod = anoMod;
		}

		public Modelo getModelo() {
			return modelo;
		}

		public void setModelo(Modelo modelo) {
			this.modelo = modelo;
		}

		public Cor getCor() {
			return cor;
		}

		public void setCor(Cor cor) {
			this.cor = cor;
		} 
		
	
	
}
