package camus.lacan.services;

import org.springframework.stereotype.Service;

import camus.lacan.domain.Palavra;

@Service
public class TonicidadeService {

	public Palavra encontrarSilabaTonica(String palavra) {
		Palavra vocabulo = new Palavra();
		SepararPalavra separarPalavra = new SepararPalavra();
		Tonicidade tonicidade = new Tonicidade();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabaTonica(tonicidade.encontrarSilabaTonica(palavra));
		return vocabulo;
	}

}
