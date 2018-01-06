package camus.lacan.domain.anafora;

import java.util.ArrayList;
import java.util.List;

public class AnaliseAnafora {

	private List<List<String>> repeticoes = new ArrayList<>();
	private List<String> versos;

	public boolean temAnaforaNosVersos(List<String> versos) {
		this.versos = versos;
		for (int posicaoVersoAtual = 0; posicaoVersoAtual < versos.size() - 1; posicaoVersoAtual++) {
			compararComVersoSeguinte(posicaoVersoAtual);
		}
		mostrarRepeticoes();
		if (repeticoes.isEmpty()) return false;
		return true;
	}

	private void mostrarRepeticoes() {
		for (List<String> lista : repeticoes) {
			lista.forEach(palavra -> System.out.println(palavra));
			System.out.println("----");
		}
	}

	private boolean compararComVersoSeguinte(int posicaoVersoAtual) {

		String versoAtual = versos.get(posicaoVersoAtual);
		String versoSeguinte = versos.get(posicaoVersoAtual + 1);

		String[] palavrasDoVersoAtual = versoAtual.split(" ");
		String[] palavrasDoVersoSeguinte = versoSeguinte.split(" ");

		int tamanhoDoMenorVerso = palavrasDoVersoAtual.length;
		if (palavrasDoVersoSeguinte.length < tamanhoDoMenorVerso) {
			tamanhoDoMenorVerso = palavrasDoVersoSeguinte.length;
		}

		List<String> palavrasRepetidas = new ArrayList<>();
		for (int i = 0; i < tamanhoDoMenorVerso; i++) {
			if (palavrasDoVersoAtual[i].equalsIgnoreCase(palavrasDoVersoSeguinte[i])) {
				palavrasRepetidas.add(palavrasDoVersoAtual[i]);
			}
		}
		if (!palavrasRepetidas.isEmpty()) {
			repeticoes.add(palavrasRepetidas);
		}
		return true;

	}
}