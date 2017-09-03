package camus.lacan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.Palavra;
import camus.lacan.services.Tonicidade;
import camus.lacan.services.TonicidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tonicidade")
@Api(value = "lacan", description = "encontrar sílaba tônica de uma palavra")
public class TonicidadeController {

	private TonicidadeService tonicidadeService;

	@Autowired
	public void setTonicidadeService(TonicidadeService tonicidadeService) {
		this.tonicidadeService = tonicidadeService;
	}

	@ApiOperation(value = "Encontra a sílaba tônica de uma palavra", response = Palavra.class)
	@RequestMapping(value = "/{palavra}", method = RequestMethod.GET, produces = "application/json")
	public Palavra encontrarSilabaTonica(@PathVariable String palavra) {
		Palavra vocabulo = new Palavra();
		Tonicidade tonicidade = new Tonicidade();
		vocabulo.setSilabaTonica(tonicidade.encontrarSilabaTonica(palavra));
		return vocabulo;
	}

}
