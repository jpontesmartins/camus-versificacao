package camus.lacan.domain.antitese;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import camus.lacan.domain.poema.Verso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/antitese")
@Api(value = "lacan", description = "procura pela existência de antitese")
public class AntiteseController {
	
	
	@ApiOperation(value = "Procura por aliteração no verso", response = Verso.class)
	@RequestMapping(value = "/verso/{texto:.+}", method = RequestMethod.GET, produces = "application/json")
	public Verso analisarVerso(@PathVariable String texto) {
		return null;
		
	}
}
