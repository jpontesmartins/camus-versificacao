package camus.lacan.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.Palavra;
import camus.lacan.domain.Poema;
import camus.lacan.services.EscansaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/escansao")
@Api(value = "lacan", description = "escandir um verso")
public class EscansaoController {
	
	
	@ApiOperation(value = "Realiza a escansão de um verso", response = Palavra.class)
	@RequestMapping(value = "/{poema}", method = RequestMethod.GET, produces = "application/json")
	public Poema escandir(@PathVariable String poema) {
		
		// 1. separar em versos (identificarVersos);
		// 2. tratar cada verso
		
		EscansaoService escansaoService = new EscansaoService();
		Poema poemaEscandido = escansaoService.escandir(poema);
		return poemaEscandido;
		
	}
}
