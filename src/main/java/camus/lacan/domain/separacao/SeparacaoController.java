package camus.lacan.domain.separacao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.Palavra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/separacao")
@Api(value = "lacan", description = "operação de separação silábica do módulo lacan do camus")
public class SeparacaoController {

	private ISeparacaoService separacaoService;

	public SeparacaoController() {
		this.separacaoService = new SeparacaoService();
	}

	@ApiOperation(value = "Conta as sílabas poéticas de um verso", response = Palavra.class)
	@RequestMapping(value = "/poetica/{verso}", method = RequestMethod.GET, produces = "application/json")
	public Palavra contarSilabasPoeticas(@PathVariable String verso) {
		Palavra vocabulo = separacaoService.separarPalavra(verso);
		return vocabulo;
	}

	@ApiOperation(value = "Conta as sílabas gramaticais de uma frase", response = Palavra.class)
	@RequestMapping(value = "/gramatical/{frase}", method = RequestMethod.GET, produces = "application/json")
	public Palavra contarSilabasGramaticais(@PathVariable String frase) {
		Palavra vocabulo = separacaoService.separarPalavra(frase);
		return vocabulo;
	}

	@ApiOperation(value = "Separa as sílabas da palavra", response = Palavra.class)
	@RequestMapping(value = "/{palavra}", method = RequestMethod.GET, produces = "application/json")
	public Palavra separarPalavra(@PathVariable String palavra) {
		Palavra vocabulo = separacaoService.separarPalavra(palavra);
		return vocabulo;
	}

}
