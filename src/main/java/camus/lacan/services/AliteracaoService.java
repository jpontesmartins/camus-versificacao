package camus.lacan.services;

import camus.lacan.domain.Aliteracao;
import camus.lacan.domain.AnaliseAliteracao;
import camus.lacan.domain.Fonema;
import camus.lacan.domain.Verso;

public class AliteracaoService {
	
	
	//Tem samba de sobra, quem sabe sambar
	public Verso analisarVerso(String texto) {
		Verso verso = new Verso(texto);
		AnaliseAliteracao analiseAliteracao = new AnaliseAliteracao();
		Fonema fonemaMaisFrequente = null;
		
		if (analiseAliteracao.temAliteracao(texto)) {
			fonemaMaisFrequente = analiseAliteracao.pegarFonemaConsonantalMaisFrequente(texto);
			
			Aliteracao aliteracao = new Aliteracao();
			aliteracao.setFonemaMaisFrequente(fonemaMaisFrequente);
			aliteracao.setTrecho(texto);
			aliteracao.getFonemaMaisFrequente().setFrequencia(analiseAliteracao.pegarFrequenciaDoFonemaEmPercentual(texto));
			
			verso.getFiguras().add(aliteracao);
		}
		
		return verso;
	}

	public Verso analisarEstrofe(Verso verso) {
		return null;
	}
	
	
}
