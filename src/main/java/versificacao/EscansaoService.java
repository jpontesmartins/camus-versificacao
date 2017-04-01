package versificacao;

import versificacao.separacao_silabica.SepararPalavra;

public class EscansaoService {
	
	public String fazerSeparacaoSilabicaDoVerso(String frase)  {
		SepararPalavra separarPalavra = new SepararPalavra();
		return separarPalavra.separarFrase(frase);
	}
}
