package com.example.demo.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "abastecimento")
public class Abastecimento {
	

				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				
				@Column(name = "id")
				private long id;
				
				@Column(name = "odo")
				private float odomentro;
				
				@Column(name = "litros")
				private float litros;
				
				@Column(name = "total_pago")
				private float totalPago;
				
				@Column(name = "nome_posto")
				private String nomePosto;
				
				@Column(name = "tipo_combustivel")
				private String tipoCombustivel;
				
				@Column(name = "placa_veiculo")
				private String placaVeiculo;
				
				@Column(name = "data_abastecimento")
				private Date dataAbastecimento;

				public long getId() {
					return id;
				}

				public void setId(long id) {
					this.id = id;
				}

				public float getOdomentro() {
					return odomentro;
				}

				public void setOdomentro(float odomentro) {
					this.odomentro = odomentro;
				}

				public float getLitros() {
					return litros;
				}

				public void setLitros(float litros) {
					this.litros = litros;
				}

				public float getTotalPago() {
					return totalPago;
				}

				public void setTotalPago(float totalPago) {
					this.totalPago = totalPago;
				}

				public String getNomePosto() {
					return nomePosto;
				}

				public void setNomePosto(String nomePosto) {
					this.nomePosto = nomePosto;
				}

				public String getTipoCombustivel() {
					return tipoCombustivel;
				}

				public void setTipCombustivel(String tipoCombustivel) {
					this.tipoCombustivel = tipoCombustivel;
				}

				public String getPlacaVeiculo() {
					return placaVeiculo;
				}

				public void setPlacaVeiculo(String placaVeiculo) {
					this.placaVeiculo = placaVeiculo;
				}

				public Date getDataAbastecimento() {
					return dataAbastecimento;
				}

				public void setDataAbastecimento(Date dataAbastecimento) {
					this.dataAbastecimento = dataAbastecimento;
				}
				
				
}

