package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.List;

public class ComparacaoDeVersos {

	private List<String> versos;

	public ComparacaoDeVersos(List<String> versos) {
		this.versos = versos;
	}
	
	public ComparacaoDeVersos() {
	}
	
	public ExpressaoRepetida compararComOutroVerso(String versoAtual, String outroVerso) {
		if (outroVerso == null)
			return null;

		String[] palavrasDoVersoAtual = versoAtual.split(" ");
		String[] palavrasDoVersoAnterior = outroVerso.split(" ");

		int tamanhoDoMenorVerso = palavrasDoVersoAtual.length;
		if (palavrasDoVersoAnterior.length < tamanhoDoMenorVerso) {
			tamanhoDoMenorVerso = palavrasDoVersoAnterior.length;
		}

		List<String> palavrasRepetidas = new ArrayList<>();
		for (int i = 0; i < tamanhoDoMenorVerso; i++) {
			if (palavrasDoVersoAtual[i].equalsIgnoreCase(palavrasDoVersoAnterior[i])) {
				palavrasRepetidas.add(palavrasDoVersoAtual[i]);
			}
		}
		String expressao = "";
		for (String string : palavrasRepetidas) {
			expressao += string + " ";
		}
		if (expressao.isEmpty()) return null;
		
		ExpressaoRepetida expressaoRepetida = new ExpressaoRepetida(expressao, versoAtual);
		return expressaoRepetida;
	}

	public String pegarVersoAnterior(int posicaoVersoAtual) {
		String versoAnterior = null;
		if (posicaoVersoAtual > 0) {
			versoAnterior = this.versos.get(posicaoVersoAtual - 1);
		}
		return versoAnterior;
	}

	public String pegarVersoPosterior(int posicaoVersoAtual) {
		String versoPosterior = null;
		if (posicaoVersoAtual < this.versos.size() - 1) {
			versoPosterior = this.versos.get(posicaoVersoAtual + 1);
		}
		return versoPosterior;
	}

	public ExpressaoRepetida compararComOutroVerso(int posicaoDoVerso, int posicaoDoOutroVerso) {
		return compararComOutroVerso(this.versos.get(posicaoDoVerso), this.versos.get(posicaoDoOutroVerso));
	}
}
