package camus.lacan.domain.aliteracao;

import java.util.List;

import camus.lacan.domain.escansao.EscansaoService;
import camus.lacan.domain.fonema.Fonema;
import camus.lacan.domain.poema.Estrofe;
import camus.lacan.domain.poema.Verso;

public class AliteracaoService {
	
	
	public Verso analisarVerso(String texto) {
		Verso verso = new Verso(texto);
		AnaliseAliteracao analiseAliteracao = new AnaliseAliteracao();
		Fonema fonemaMaisFrequente = null;
		
		if (analiseAliteracao.temAliteracao(texto)) {
			fonemaMaisFrequente = analiseAliteracao.pegarFonemaConsonantalMaisFrequente(texto);
			
			Aliteracao aliteracao = new Aliteracao();
			aliteracao.setFonemaMaisFrequente(fonemaMaisFrequente);
			aliteracao.setTrecho(texto);
			verso.getFiguras().add(aliteracao);
		}
		
		return verso;
	}

	public Estrofe analisarEstrofe(String texto) {
		EscansaoService escansaoService = new EscansaoService();
		List<Verso> versos = escansaoService.identificarVersos(texto);
		Estrofe estrofe = new Estrofe();
		for (Verso verso : versos) {
			verso = analisarVerso(verso.getVerso());
			estrofe.getVersos().add(verso);	
		}
		return estrofe;
	}
	
	
}
