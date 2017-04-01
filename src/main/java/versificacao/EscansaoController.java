package versificacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import versificacao.entidades.Poema;

@RestController
public class EscansaoController {
	
	public static final String DICIO = "https://www.dicio.com.br/";

	@RequestMapping(value = "/versificar", method = RequestMethod.GET)
	public String versificarGet(@RequestParam String poemaTexto) throws FileNotFoundException, IOException, Exception {
		System.out.println("chamado por get");
		System.out.println(poemaTexto);
		EscansaoService escansaoService = new EscansaoService();
		String palavraSeparada = escansaoService.fazerSeparacaoSilabicaDoVerso(poemaTexto);
		Poema poema = new Poema();
		poema.setPoema(poemaTexto);
		poema.setPoemaVersificado(palavraSeparada);
		Gson gson = new Gson();
		return gson.toJson(poema);
		
	}
	

}