package camus.lacan.domain.escansao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.InformacoesDaPalavra;
import camus.lacan.domain.poema.Poema;
import camus.lacan.domain.poema.Verso;

public class EscansaoService {
	
	private static final String TERMINO_DE_VERSO = "§";

	public Poema escandir(String poema) {
		Poema poemaEscandido = new Poema();
		poemaEscandido.setPoema(poema);
		poemaEscandido.setVersos(identificarVersos(poema));
		
		for (Verso verso : poemaEscandido.getVersos()) {
			verso.setPalavras(new InformacoesDaPalavra().preencherInformacoesDasPalavras(verso.getVerso()));
		}
		
		return poemaEscandido;
	}
	
	public int contarVersos(String poema) {
		List<String> versos = new ArrayList<String>(Arrays.asList(poema.split(TERMINO_DE_VERSO)));
		versos.removeIf(p-> p.length() == 0);
		return versos.size();
	}
	
	public List<Verso> identificarVersos(String poema) {
		List<String> versosNaoTratados = new ArrayList<String>(Arrays.asList(poema.split(TERMINO_DE_VERSO)));
		List<Verso> versos = new ArrayList<>();
		versosNaoTratados.forEach(versoSemTratamento -> versos.add(new Verso(versoSemTratamento.replaceAll("Â",""))));
		return versos;
	}

	public int contarEstrofes(String poema) {
		return Arrays.asList(poema.split("§§")).size();
	}
	
	
	
	

}
