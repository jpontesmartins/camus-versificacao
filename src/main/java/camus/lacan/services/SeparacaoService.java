package camus.lacan.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import camus.lacan.domain.Palavra;

@Service
public class SeparacaoService {

	public Palavra separarPalavra(String palavra) {
		Palavra vocabulo = new Palavra();
		SepararPalavra separarPalavra = new SepararPalavra();
		vocabulo.setGrafia(palavra);
//		vocabulo.setGrafiaSeparada(separarPalavra.separar(palavra));
//		vocabulo.setSilabas(Arrays.asList(vocabulo.getGrafiaSeparada().split(" ")));
		return vocabulo;
	}
}
