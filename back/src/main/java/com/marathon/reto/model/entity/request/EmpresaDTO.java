package com.marathon.reto.model.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmpresaDTO {

	@JsonProperty("ruc")
	private String ruc;

	@JsonProperty("razon_social")
	private String razonSocial;

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("direccion")
	private String direccion;

	@JsonProperty("ubigeo")
	private String ubigeo;

	@JsonProperty("departamento")
	private String departamento;

	@JsonProperty("provincia")
	private String provincia;

	@JsonProperty("distrito")
	private String distrito;

	public EmpresaDTO(String ruc, String razonSocial, String estado, String direccion, String ubigeo, String departamento, String provincia, String distrito) {
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
