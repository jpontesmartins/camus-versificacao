package versificacao.figurasdelinguagem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import versificacao.utils.Letras;

public class Aliteracao {

	public static void main(String[] args) {

		Aliteracao f = new Aliteracao();
		String frase = "o rato roeu a roupa do rei de roma";
		f.descobrirFonemasMaisFrequentes(frase);

	}

	public Map<String, Integer> descobrirFonemasMaisFrequentes(String frase) {
		String palavras[] = frase.toLowerCase().split(" ");
		Map<String, Integer> mapaDeLetrasEFrequencia = new HashMap<>();
		for (String palavra : palavras) {
			for (int i = 0; i < palavra.length(); i++) {
				String chave = "" + palavra.charAt(i);
				Integer valorAtual = mapaDeLetrasEFrequencia.get(chave);
				if (valorAtual == null)
					valorAtual = 0;
				int peso = atribuirPesoDaLetra(i, chave);
				mapaDeLetrasEFrequencia.put(chave, valorAtual + peso);
			}
		}

		List<String> consoantes = new ArrayList<>();
		Map<String, Integer> mapaFrequenciaConsoantes = new HashMap<>();
		for (String chave : mapaDeLetrasEFrequencia.keySet()) {
			if (Arrays.asList(Letras.CONSOANTES).contains(chave)) {
				consoantes.add(chave);
				mapaFrequenciaConsoantes.put(chave, mapaDeLetrasEFrequencia.get(chave));
			}
		}

		return mapaFrequenciaConsoantes;
	}

	private int atribuirPesoDaLetra(int posicaoDaLetra, String palavra) {
		if (isPrimeiraLetraDaPalavra(posicaoDaLetra, palavra))
			return 2;
		
		return 1;
	}

	private boolean isPrimeiraLetraDaPalavra(int posicaoDaLetra, String chave) {
		return posicaoDaLetra == 0 && Letras.isConsoante(chave);
	}

}
