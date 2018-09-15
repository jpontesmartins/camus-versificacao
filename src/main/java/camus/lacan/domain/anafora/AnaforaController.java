package camus.lacan.domain.anafora;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.poema.Estrofe;
import camus.lacan.domain.poema.Verso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/anafora")
@Api(value = "lacan", description = "procura pela existência de anáfora")
public class AnaforaController {

	private static final String ENDPOINT_ESTROFE = "/estrofe/{texto:.+}";
	private static final String ANAFORA_NA_ESTROFE = "Procura por anáfora na estrofe";
	private static final String APPLICATION_JSON = "application/json";

	private IAnaforaService anaforaService;

	public AnaforaController() {
		this.anaforaService = new AnaforaService();
	}
	public AnaforaController(IAnaforaService anaforaService) {
		this.anaforaService = anaforaService;
	}

	@ApiOperation(value = ANAFORA_NA_ESTROFE, response = Verso.class)
	@RequestMapping(value = ENDPOINT_ESTROFE, method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Estrofe analisarEstrofe(@PathVariable String texto) {
		Estrofe estrofeAnalisada = anaforaService.analisarEstrofe(new Estrofe(texto));

		return estrofeAnalisada;
	}

}
