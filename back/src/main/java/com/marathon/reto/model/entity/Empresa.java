package com.marathon.reto.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
@NoArgsConstructor
@Getter
@Setter
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ruc")
	private String ruc;

	@Column(name = "razon_social")
	private String razonSocial;

	@Column(name = "estado")
	private String estado;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "ubigeo")
	private String ubigeo;

	@Column(name = "departamento")
	private String departamento;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "distrito")
	private String distrito;

	public Empresa(String ruc, String razonSocial, String estado, String direccion,String ubigeo, String departamento,String provincia, String distrito) {
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.estado = estado;
		this.direccion = direccion;
		this.ubigeo = ubigeo;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
	}


}
