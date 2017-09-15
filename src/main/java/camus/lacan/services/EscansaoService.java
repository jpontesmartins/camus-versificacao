package camus.lacan.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.Palavra;

public class EscansaoService {

	public String fazerSeparacaoSilabicaDoVerso(String frase) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String fraseSeparada = separarPalavra.separar(frase);
		return fraseSeparada;
	}

	public List<Palavra> pegarInformacoesDasPalavras(String frase) {
		List<Palavra> palavras = new ArrayList<>();
		Arrays.asList(frase.split(" ")).forEach(palavraStr -> palavras.add(new Palavra(palavraStr)));
		return palavras;
	}

}
