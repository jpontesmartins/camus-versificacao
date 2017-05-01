package versificacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import versificacao.entidades.Palavra;
import versificacao.separacao_silabica.SepararPalavra;

public class EscansaoService {

	public static void main(String[] args) {
		System.out.println(new EscansaoService().fazerSeparacaoSilabicaDoVerso("de repente"));
	}

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
