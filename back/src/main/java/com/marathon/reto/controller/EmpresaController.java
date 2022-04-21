package com.marathon.reto.controller;

import com.marathon.reto.model.configuration.RucClientConfig;
import com.marathon.reto.model.constantes.Constantes;
import com.marathon.reto.model.entity.request.EmpresaDTO;
import com.marathon.reto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marathon.reto.model.entity.Empresa;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
@RestController
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	private RucClientConfig rucClientConfig;

	@PostMapping("/register/{tipo}/{ruc}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable("ruc") String ruc, @PathVariable("tipo") String tipo) {
		EmpresaDTO empresa = rucClientConfig.get(String.format(Constantes.URI_OBTENER_RUC, tipo,ruc),new ParameterizedTypeReference<EmpresaDTO>(){});

		try {
			Empresa _empresa = empresaRepository
					.save(new Empresa(empresa.getRuc(), empresa.getRazonSocial(),empresa.getEstado(),
							empresa.getDireccion(),empresa.getUbigeo(),empresa.getDepartamento(),
							empresa.getProvincia(),empresa.getDistrito()));
			return new ResponseEntity<>(_empresa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
