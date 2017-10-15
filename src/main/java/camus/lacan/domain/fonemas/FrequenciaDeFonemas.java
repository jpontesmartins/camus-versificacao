package camus.lacan.domain.fonemas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import camus.lacan.domain.AnaliseAliteracao;
import camus.lacan.domain.AnaliseFonemas;
import camus.lacan.domain.ConversaoEmFonema;
import camus.lacan.domain.Fonema;
import camus.lacan.domain.Palavra;

public class FrequenciaDeFonemas {

	public Fonema pegarFonemaConsonantalMaisFrequente(String frase) {
		frase = frase.toLowerCase();
		List<Fonema> fonemasConsonantais = new AnaliseFonemas()
				.pegarApenasFonemasConsonantais(new FrequenciaDeFonemas().listarFonemasDecrescente(frase));
		return fonemasConsonantais.get(0);
	}

	public List<Fonema> listarFonemasUnicosComFrequencia(List<Fonema> todosOsFonemas) {
		todosOsFonemas.sort(new Comparator<Fonema>() {
			@Override
			public int compare(Fonema o1, Fonema o2) {
				return new Double(o2.getFrequencia()).compareTo(o1.getFrequencia());
			}
		});
		List<Fonema> fonemasNaoRepetidos = removerFonemasRepetidos(todosOsFonemas);
		return fonemasNaoRepetidos;
	}

	public List<Fonema> listarFonemasDecrescente(String frase) {
		return listarFonemasUnicosComFrequencia(new AnaliseAliteracao().pegarFonemasDaFrase(frase));
	}

	private List<Fonema> removerFonemasRepetidos(List<Fonema> todosOsFonemas) {
		List<Fonema> fonemasNaoRepetidos = new ArrayList<>();
		todosOsFonemas.forEach(fonema -> {
			if (!isFonemaNaLista(fonema, fonemasNaoRepetidos)) {
				fonemasNaoRepetidos.add(fonema);
			}
		});
		return fonemasNaoRepetidos;
	}

	public Map<String, Integer> contarFrequenciaDosFonemas(List<Palavra> palavras) {
		Map<String, Integer> mapaDeFonemasEFrequencia = new TreeMap<String, Integer>();
		for (Palavra vocabulo : palavras) {
			List<Fonema> fonemas = vocabulo.getFonemas();

			for (Fonema fonema : fonemas) {
				String chave = fonema.getFonema();
				Integer valorAtual = mapaDeFonemasEFrequencia.get(chave);
				if (valorAtual == null)
					valorAtual = 0;
				int peso = calcularPesoDoFonema(vocabulo, fonemas, fonema);

				mapaDeFonemasEFrequencia.put(chave, valorAtual + peso);
			}
		}
		return mapaDeFonemasEFrequencia;
	}

	public double pegarFrequenciaDoFonemaMaisFrequenteEmPercentual(String texto) {
		int totalDePalavras = texto.split(" ").length;
		int qtdeConsoanteInicialMaisFrequente = totalPalavrasIniciamConsoanteMaisFrequente(texto,pegarFonemaConsonantalMaisFrequente(texto));
		
		double resultado = (100 * qtdeConsoanteInicialMaisFrequente)/totalDePalavras;
		return resultado;
		
//		return (100 * pegarFonemaMaisFrequente(texto).getFrequencia()) / new AnaliseAliteracao().pegarFonemasDaFrase(texto).size();
	}

	private int totalPalavrasIniciamConsoanteMaisFrequente(String texto, Fonema pegarFonemaMaisFrequente) {
		String palavras[] = texto.toLowerCase().split(" ");
		int retorno = 0;
		for (String palavra : palavras) {
			List<Fonema> fonemasDaPalavra = new ConversaoEmFonema().descobrirFonemasDaPalavra(palavra);
			if (fonemasDaPalavra.get(0).getFonema().equals(pegarFonemaMaisFrequente.getFonema())) {
				retorno++;
			}
		}
		return retorno;
	}

	private Fonema pegarFonemaMaisFrequente(String frase) {
		return new FrequenciaDeFonemas().listarFonemasDecrescente(frase).get(0);
	}

	private int calcularPesoDoFonema(Palavra vocabulo, List<Fonema> fonemas, Fonema fonema) {
		int peso = 1;
		if ((vocabulo.getGrafia().charAt(0) + "").equals(fonema.getGrafia())) {
			peso = 2;
		}
		return peso;
	}

	private boolean isFonemaNaLista(Fonema fonema, List<Fonema> fonemasNaoRepetidos) {
		for (Fonema fonemaDaLista : fonemasNaoRepetidos) {
			if (fonemaDaLista.getFonema().equals(fonema.getFonema())) {
				return true;
			}
		}
		return false;
	}
}
