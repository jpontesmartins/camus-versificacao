package camus.lacan.domain.anafora;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.poema.Estrofe;
import camus.lacan.domain.poema.Verso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/anafora")
@Api(value = "lacan", description = "procura pela existência de anáfora")
public class AnaforaController {
	
	@ApiOperation(value = "Procura por anáfora no verso", response = Verso.class)
	@RequestMapping(value = "/estrofe/{texto:.+}", method = RequestMethod.GET, produces = "application/json")
	public Estrofe analisarEstrofe(@PathVariable String texto) {
		AnaforaService anaforaService = new AnaforaService();
		Estrofe estrofeAnalisado = anaforaService.analisarEstrofe(texto);
		return estrofeAnalisado;
	}
	
}
