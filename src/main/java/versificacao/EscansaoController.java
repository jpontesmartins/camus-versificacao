package versificacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import versificacao.entidades.Poema;

@RestController
public class EscansaoController {
	
	public static void main(String[] args) {
		EscansaoController e = new EscansaoController();
		System.out.println(e.versificarGet("de repente não mais que de repente"));
	}
	
	
	@RequestMapping(value = "/versificar", method = RequestMethod.GET)
	public String versificarGet(@RequestParam String poemaTexto) {
		EscansaoService escansaoService = new EscansaoService();
		String verso = escansaoService.fazerSeparacaoSilabicaDoVerso(poemaTexto);
		Poema poema = new Poema();
		poema.setPoema(poemaTexto);
		poema.setPoemaVersificado(verso);
		poema.setPalavras(escansaoService.pegarInformacoesDasPalavras(poemaTexto));
		Gson gson = new Gson();
		return gson.toJson(poema);
		
	}
	
}