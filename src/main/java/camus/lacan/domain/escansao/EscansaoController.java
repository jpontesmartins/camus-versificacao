package camus.lacan.domain.escansao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.poema.Poema;
import camus.lacan.domain.poema.Verso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/escansao")
@Api(value = "lacan", description = "escandir um verso")
public class EscansaoController {
	
	
	@ApiOperation(value = "Realiza a escansão de um verso", response = Poema.class)
	@RequestMapping(value = "/{poema:.+}", method = RequestMethod.GET, produces = "application/json")
	public Poema escandir(@PathVariable String poema) {
		
		EscansaoService escansaoService = new EscansaoService();
		Poema poemaEscandido = escansaoService.escandir(poema);
		
		for (Verso verso : poemaEscandido.getVersos()) {
			System.out.println(verso.getVerso());
		}
		
		return poemaEscandido;
		
	}
}
