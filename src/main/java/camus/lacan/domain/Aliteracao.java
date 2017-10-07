package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.Map.Entry;

import camus.lacan.utils.Fonemas;

public class Aliteracao {

	public static void main(String[] args) {
		new Aliteracao().descobrirFonemasMaisFrequentes_NEW("o peito do pé do pedro é preto");
	}

	//TODO: falta
	public List<Fonema> descobrirFonemasMaisFrequentes_NEW(String frase) {
		String palavras[] = frase.split(" ");
		List<Fonema> todosOsFonemas = new ArrayList<>();
		for (String palavra : palavras) {
			todosOsFonemas.addAll(new ConversaoEmFonema().descobrirFonemasDaPalavra(palavra));
		}

		Map<String, Integer> mapaDeFonemasEFrequencia = new HashMap<>();
		for (int i = 0; i < todosOsFonemas.size(); i++) {
			String chave = todosOsFonemas.get(i).getFonema();
			Integer valorAtual = mapaDeFonemasEFrequencia.get(chave);
			if (valorAtual == null)
				valorAtual = 0;
			int peso = 1;
			mapaDeFonemasEFrequencia.put(chave, valorAtual + peso);
		}

		List<Fonema> emOrdem = new ArrayList<>();

		todosOsFonemas.forEach(f -> f.setFrequencia(mapaDeFonemasEFrequencia.get(f.getFonema())));
		todosOsFonemas.sort(new Comparator<Fonema>() {
			@Override
			public int compare(Fonema o1, Fonema o2) {
				return new Integer(o2.getFrequencia()).compareTo(o1.getFrequencia());
			}
		});

		todosOsFonemas.forEach(f -> System.out.println(
				f.getFonema() + "," + 
				f.getGrafia() + "," + 
				f.getFrequencia()));

		return todosOsFonemas;

	}

	public Map<String, Integer> descobrirFonemasMaisFrequentes(String frase) {
		ConversaoEmFonema fonema = new ConversaoEmFonema();
		List<String> palavrasTranscritas = fonema.transcreverFrase(frase);

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
		int qtdePalavras = frase.split(" ").length;
		Fonema fonemaDeMaiorFrequencia = pegarFonemaMaisFrequente(frase);

	}

	public Fonema pegarFonemaMaisFrequente(String frase) {
		return descobrirFonemasMaisFrequentes_NEW(frase).get(0);
	}

}
