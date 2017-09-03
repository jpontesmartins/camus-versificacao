package camus.lacan.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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
	@RequestMapping(value = "/{verso}", method = RequestMethod.GET, produces = "application/json")
	public Poema escandir(@PathVariable String verso) {
		EscansaoService escansaoService = new EscansaoService();
		String versoSeparado = escansaoService.fazerSeparacaoSilabicaDoVerso(verso);
		Poema poema = new Poema();
		poema.setPoema(verso);
		poema.setPoemaVersificado(versoSeparado);
		poema.setPalavras(escansaoService.pegarInformacoesDasPalavras(verso));
//		Gson gson = new Gson();
//		return gson.toJson(poema);
		return poema;
		
	}
}
