package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camus.lacan.utils.Fonemas;

public class Aliteracao {

	public Map<String, Integer> descobrirFonemasMaisFrequentes(String frase) {
		Fonema fonema = new Fonema();
		List<String> palavrasTranscritas = fonema.transcreverFrase(frase);

		Map<String, Integer> mapaDeFonemasEFrequencia = new HashMap<>();
		for (String palavra : palavrasTranscritas) {
			String fonemasDaPalavra[] = palavra.split(" ");
			for (int i = 0; i < fonemasDaPalavra.length; i++) {
				String chave = "" + fonemasDaPalavra[i];
				Integer valorAtual = mapaDeFonemasEFrequencia.get(chave);
				if (valorAtual == null)
					valorAtual = 0;
				int peso = atribuirPesoDaLetra(i, chave);
				mapaDeFonemasEFrequencia.put(chave, valorAtual + peso);
			}

		}

		List<String> fonemasConsonantais = new ArrayList<>();
		Map<String, Integer> mapaFrequenciaFonemasConsonantais = new HashMap<>();
		for (String chave : mapaDeFonemasEFrequencia.keySet()) {
			if (Arrays.asList(Fonemas.FONEMAS_CONSONANTAIS).contains(chave)) {
				fonemasConsonantais.add(chave);
				mapaFrequenciaFonemasConsonantais.put(chave, mapaDeFonemasEFrequencia.get(chave));
			}
		}

		return mapaFrequenciaFonemasConsonantais;
	}

	private int atribuirPesoDaLetra(int posicaoDaLetra, String palavra) {
		if (isPrimeiraLetraDaPalavra(posicaoDaLetra, palavra))
			return 2;

		return 1;
	}

	private boolean isPrimeiraLetraDaPalavra(int posicaoDaLetra, String chave) {
		return posicaoDaLetra == 0 && Fonemas.isFonemaConsonantal(chave);
	}

}
