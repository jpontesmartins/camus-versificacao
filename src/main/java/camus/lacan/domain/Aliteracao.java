package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.Map.Entry;

import camus.lacan.utils.Fonemas;

public class Aliteracao {

//	private Map<String, Integer> mapaDeFonemasEFrequencia;

	public Map<String, Integer> descobrirFonemasMaisFrequentes(String frase) {
		ConversaoEmFonema fonema = new ConversaoEmFonema();
		List<String> palavrasTranscritas = fonema.transcreverFrase(frase);

//		mapaDeFonemasEFrequencia = new TreeMap<>();
		 Map<String, Integer> mapaDeFonemasEFrequencia = new TreeMap<>();

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
			if (isFonemaConsonantal(chave)) {
				fonemasConsonantais.add(chave);
				mapaFrequenciaFonemasConsonantais.put(chave, mapaDeFonemasEFrequencia.get(chave));
			}
		}

		return mapaFrequenciaFonemasConsonantais;
	}

	private boolean isFonemaConsonantal(String chave) {
		return Arrays.asList(Fonemas.FONEMAS_CONSONANTAIS).contains(chave);
	}

	private int atribuirPesoDaLetra(int posicaoDaLetra, String palavra) {
		if (isPrimeiraLetraDaPalavra(posicaoDaLetra, palavra))
			return 2;

		return 1;
	}

	private boolean isPrimeiraLetraDaPalavra(int posicaoDaLetra, String chave) {
		return posicaoDaLetra == 0 && Fonemas.isFonemaConsonantal(chave);
	}

	public void temAliteracao(String frase) {
//		String palavras[] = frase.split(" ");
//		int quantidadeDePalavras = palavras.length;
		
	}

//	private Map<String, Integer> fonemasEmOrdemDeFrequencia(String frase) {
//		
//	}

}
