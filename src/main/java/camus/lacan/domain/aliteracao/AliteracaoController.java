package camus.lacan.domain.aliteracao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.poema.Estrofe;
import camus.lacan.domain.poema.Verso;
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
		AliteracaoService aliteracaoService = new AliteracaoService();
		Estrofe estrofe = aliteracaoService.analisarEstrofe(texto);
		return estrofe;
	}
}
