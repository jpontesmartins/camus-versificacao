package camus.lacan.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import camus.lacan.controllers.Escansao;
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

	public String substituirQuebraDeLinha(String frase) {
		return frase.replaceAll("§", "\n");
	}
	
	public int contarVersos(String poema) {
		List<String> versos = new ArrayList<String>(Arrays.asList(poema.split("§")));
		versos.removeIf(p-> p.length() == 0);
		return versos.size();
	}

	public int contarEstrofes(String poema) {
		
		return Arrays.asList(poema.split("§§")).size();
	}
	
	public static void main(String[] args) {
		String poema = "v1§v2§v3§§v4§v5§v6";
		new EscansaoService().contarVersos(poema);
		
		
		
//		String naoTratada = "ola§tudo bem?";
//		System.out.println(new EscansaoService().substituirQuebraDeLinha(naoTratada));
//		
//		Escansao esc = new Escansao();
//		System.out.println();
//		
//		List<String> aa = esc.listarSilabasPoeticas("Quero vivê-lo em cada vão momento");
//		aa.forEach(posicao -> System.out.println(posicao));
	}

	
	
	
	
	
	

}
