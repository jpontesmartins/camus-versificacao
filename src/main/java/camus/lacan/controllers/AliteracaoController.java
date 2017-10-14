package camus.lacan.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.Estrofe;
import camus.lacan.domain.Palavra;
import camus.lacan.domain.Poema;
import camus.lacan.domain.Verso;
import camus.lacan.services.AliteracaoService;
import camus.lacan.services.EscansaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aliteracao")
@Api(value = "lacan", description = "procura pela existência de aliteração")
public class AliteracaoController {
	
	
	@ApiOperation(value = "Procura por aliteração no verso", response = Verso.class)
	@RequestMapping(value = "/verso/{texto:.+}", method = RequestMethod.GET, produces = "application/json")
	public Verso analisarVerso(@PathVariable String texto) {
		AliteracaoService aliterecaoService = new AliteracaoService();
		Verso versoAnalisado = aliterecaoService.analisarVerso(texto);
		return versoAnalisado;
	}
	
	@ApiOperation(value = "Procura por aliteração na estrofe", response = Verso.class)
	@RequestMapping(value = "/estrofe/{texto:.+}", method = RequestMethod.GET, produces = "application/json")
	public Estrofe analisarEstrofe(@PathVariable String texto) {
//		System.out.println("Aliteração na estrofe " + texto);
		Estrofe estrofe = new Estrofe();
//		estrofe.setVersos(new EscansaoService().identificarVersos(texto));
//		AliteracaoService aliterecaoService = new AliteracaoService();
//		Verso versoAnalisado = aliterecaoService.analisarVerso(texto);
		
		return estrofe;
	}
}
