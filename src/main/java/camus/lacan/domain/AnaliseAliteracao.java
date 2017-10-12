package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import camus.lacan.utils.Fonemas;

public class AnaliseAliteracao {

	public static void main(String[] args) {
		String frase = "o peito do pé do pedro é preto";
		List<Fonema> fonemas = new AnaliseAliteracao().descobrirFonemasMaisFrequentes(frase);
		new AnaliseAliteracao().descobrirFonemasMaisFrequentes("o peito do pé do pedro é preto");
		fonemas.forEach(f -> System.out.println(f.getFonema() + "," + f.getGrafia() + "," + f.getFrequencia()));
		System.out.println("-------------");
		new AnaliseAliteracao().temAliteracao(frase);
	}

	public List<Fonema> descobrirFonemasMaisFrequentes(String frase) {

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

		todosOsFonemas.forEach(f -> f.setFrequencia(contarFrequenciaDosFonemas(vocabulos).get(f.getFonema())));
		todosOsFonemas.sort(new Comparator<Fonema>() {
			@Override
			public int compare(Fonema o1, Fonema o2) {
				return new Integer(o2.getFrequencia()).compareTo(o1.getFrequencia());
			}
		});
		List<Fonema> fonemasNaoRepetidos = removerFonemasRepetidos(todosOsFonemas);
		return fonemasNaoRepetidos;

	}

	public List<Fonema> removerFonemasRepetidos(List<Fonema> todosOsFonemas) {
		List<Fonema> fonemasNaoRepetidos = new ArrayList<>();
		todosOsFonemas.forEach(fonema -> {
			if (!isFonemaNaLista(fonema, fonemasNaoRepetidos)) {
				fonemasNaoRepetidos.add(fonema);
			}
		});
		return fonemasNaoRepetidos;
	}

	private boolean isFonemaNaLista(Fonema fonema, List<Fonema> fonemasNaoRepetidos) {
		for (Fonema fonemaDaLista : fonemasNaoRepetidos) {
			if (fonemaDaLista.getFonema().equals(fonema.getFonema())) {
				return true;
			}
		}
		return false;
	}

	private Map<String, Integer> contarFrequenciaDosFonemas(List<Palavra> palavras) {
		Map<String, Integer> mapaDeFonemasEFrequencia = new TreeMap<String, Integer>();
		for (Palavra vocabulo : palavras) {
			List<Fonema> fonemas = vocabulo.getFonemas();

			for (int i = 0; i < fonemas.size(); i++) {
				String chave = fonemas.get(i).getFonema();
				Integer valorAtual = mapaDeFonemasEFrequencia.get(chave);
				if (valorAtual == null)
					valorAtual = 0;
				int peso = 1;
				if ((vocabulo.getGrafia().charAt(0) + "").equals(fonemas.get(i).getGrafia())) {
					peso = 2;
				}

				mapaDeFonemasEFrequencia.put(chave, valorAtual + peso);
			}
		}
		return mapaDeFonemasEFrequencia;
	}

	public boolean temAliteracao(String frase) {
		int qtdePalavras = frase.toLowerCase().split(" ").length;
		Fonema fonemaDeMaiorFrequencia = pegarFonemaConsonantalMaisFrequente(frase);
		if (calcularRegraDaAliteracao(qtdePalavras, fonemaDeMaiorFrequencia))
			return true;
		return false;
	}

	private boolean calcularRegraDaAliteracao(int qtdePalavras, Fonema fonemaDeMaiorFrequencia) {
		return fonemaDeMaiorFrequencia.getFrequencia() >= qtdePalavras / 2;
	}

	public Fonema pegarFonemaMaisFrequente(String frase) {
		return descobrirFonemasMaisFrequentes(frase).get(0);
	}

	public Fonema pegarFonemaConsonantalMaisFrequente(String frase) {
		List<Fonema> fonemas = descobrirFonemasMaisFrequentes(frase);
		List<Fonema> fonemasConsonantais = new ArrayList<>();
		fonemas.forEach(fonema -> {
			if (Fonemas.isFonemaConsonantal(fonema.getFonema())) {
				fonemasConsonantais.add(fonema);
			}
		});
		return fonemasConsonantais.get(0);
	}

}
