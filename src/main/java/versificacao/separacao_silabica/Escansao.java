package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.List;

public class Escansao {

	public int quantidadeSilabasGramaticais(String verso) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String versoSeparado = separarPalavra.separarFrase(verso);
		String versos[] = versoSeparado.split(" ");
		return versos.length;
	}

	public int quantidadeSilabasPoeticas(String verso) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String versoSeparado = separarPalavra.separarFrase(verso);
		String silabas[] = versoSeparado.split(" ");
		List<String> separacaoPoetica = new ArrayList<String>();

		for (int i = 0; i < silabas.length; i++) {
			System.out.println(silabas[i]);
			String silabaAtual = silabas[i];
			String silaba = silabaAtual;

			if (i < silabas.length - 1) {
				String silabaSeguinte = silabas[i + 1];
				char ultimaLetra = silabaAtual.charAt(silabaAtual.length() - 1);
				char primeiraLetra = silabaSeguinte.charAt(0);

				if (separarPalavra.isVogal(ultimaLetra) && separarPalavra.isVogal(primeiraLetra)) {
					silaba = silabaAtual + "" + silabaSeguinte;
					i++;
				} else {
					silaba = silabaAtual;
				}
			}
			separacaoPoetica.add(silaba);
		}
		return separacaoPoetica.size();
	}

}
