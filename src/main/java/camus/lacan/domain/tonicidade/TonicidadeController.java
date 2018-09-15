package camus.lacan.domain.tonicidade;

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
@RequestMapping("/tonicidade")
@Api(value = "lacan", description = "encontrar sílaba tônica de uma palavra")
public class TonicidadeController {

	private ITonicidadeService tonicidadeService;
	
	public TonicidadeController() {
		this.tonicidadeService = new TonicidadeService();
	}

	@ApiOperation(value = "Encontra a sílaba tônica de uma palavra", response = Palavra.class)
	@RequestMapping(value = "/{palavra}", method = RequestMethod.GET, produces = "application/json")
	public Palavra encontrarSilabaTonica(@PathVariable String palavra) {
		Palavra vocabulo = new Palavra();
		vocabulo = tonicidadeService.encontrarSilabaTonica(palavra);
		return vocabulo;
	}

}
