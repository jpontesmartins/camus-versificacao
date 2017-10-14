package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import camus.lacan.domain.fonemas.FrequenciaDeFonemas;
import camus.lacan.utils.Fonemas;

public class AnaliseAliteracao {

	public boolean temAliteracao(String frase) {
		int qtdePalavras = frase.toLowerCase().split(" ").length;
		Fonema fonemaDeMaiorFrequencia = new FrequenciaDeFonemas().pegarFonemaConsonantalMaisFrequente(frase);
		if (calcularRegraDaAliteracao(qtdePalavras, fonemaDeMaiorFrequencia))
			return true;
		return false;
	}

	public List<Fonema> pegarFonemasDaFrase(String frase) {
		String palavras[] = frase.toLowerCase().split(" ");
		List<Fonema> todosOsFonemas = new ArrayList<>();
		List<Palavra> vocabulos = new ArrayList<>();

		for (String palavra : palavras) {
			List<Fonema> descobrirFonemasDaPalavra = new ConversaoEmFonema().descobrirFonemasDaPalavra(palavra);
			Palavra vocabulo = new Palavra();
			vocabulo.setGrafia(palavra);
			vocabulo.setFonemas(descobrirFonemasDaPalavra);
			vocabulos.add(vocabulo);
			todosOsFonemas.addAll(descobrirFonemasDaPalavra);
		}

		todosOsFonemas.forEach(f -> f
				.setFrequencia(new FrequenciaDeFonemas().contarFrequenciaDosFonemas(vocabulos).get(f.getFonema())));
		return todosOsFonemas;
	}

	public Fonema pegarFonemaMaisFrequente(String frase) {
		return new FrequenciaDeFonemas().listarFonemasDecrescente(frase).get(0);
	}

	public Fonema pegarFonemaConsonantalMaisFrequente(String frase) {
		List<Fonema> fonemasConsonantais = new AnaliseFonemas()
				.pegarApenasFonemasConsonantais(new FrequenciaDeFonemas().listarFonemasDecrescente(frase));
		return fonemasConsonantais.get(0);
	}

	public double pegarFrequenciaDoFonemaEmPercentual(String texto) {
		return new FrequenciaDeFonemas().pegarFrequenciaDoFonemaEmPercentual(texto);
	}

	private boolean calcularRegraDaAliteracao(int qtdePalavras, Fonema fonemaDeMaiorFrequencia) {
		return fonemaDeMaiorFrequencia.getFrequencia() >= qtdePalavras / 2;
	}

}
