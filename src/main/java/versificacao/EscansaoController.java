package versificacao;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EscansaoController {

	@RequestMapping(value = "/versificar", method = RequestMethod.POST)
	public String versificar(@RequestParam String poemaTexto) {
		System.out.println("chamado por post");
		EscansaoService escansaoService = new EscansaoService();
		System.out.println(poemaTexto);
		String versificado = "de/ re/ pen/ te/ n�o/ mais/ que/ de/ re/ pen/ te";
		Poema poema = new Poema("de repente nao mais que de repente", versificado);
		poema.setPoema(poemaTexto);
		String palavraSeparada = escansaoService.fazerSeparacaoSilabicaDeUmaPalavra(poemaTexto);
		poema.setPoemaVersificado(palavraSeparada);
		Gson gson = new Gson();
		return gson.toJson(poema);
	}
	
	@RequestMapping(value = "/versificar", method = RequestMethod.GET)
	public String versificarGet(@RequestParam String poemaTexto) {
		System.out.println("chamado por get");
		EscansaoService escansaoService = new EscansaoService();
		System.out.println(poemaTexto);
		String versificado = "de/ re/ pen/ te/ n�o/ mais/ que/ de/ re/ pen/ te";
		Poema poema = new Poema("de repente nao mais que de repente", versificado);
		poema.setPoema(poemaTexto);
		String palavraSeparada = escansaoService.fazerSeparacaoSilabicaDeUmaPalavra(poemaTexto);
		poema.setPoemaVersificado(palavraSeparada);
		Gson gson = new Gson();
		return gson.toJson(poema);
	}

}