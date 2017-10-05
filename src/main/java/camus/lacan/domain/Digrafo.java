package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.utils.Letras;

public class Digrafo {

	private static final Integer DUAS_LETRAS_SEGUINTE = 2;

	public Boolean contemDigrafoEspecifico(String digrafo, String palavra) {
		List<String> possiveisDigrafos = encontrarDigrafos(palavra);
		if (possiveisDigrafos.isEmpty())
			return false;
		for (String possivelDigrafo : possiveisDigrafos) {
			if (possivelDigrafo.equals(digrafo)) {
				return temDigrafo(palavra, possivelDigrafo);
			}
		}
		return false;
	}

	private boolean temDigrafo(String palavra, String digrafoEspecifico) {
		for (String digrafoVocalico : Arrays.asList(Letras.DIGRAFOS_VOGAIS_NASAIS)) {
			if (palavra.contains(digrafoVocalico)
					&& (digrafoEspecifico != null && digrafoEspecifico.equals(digrafoVocalico))) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_SEGUINTE < palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";

						if (temDigrafoVocalico(letra, letraSeguinte)) {
							return !Arrays.asList(Letras.VOGAIS).contains(letraAposODigrafo);

						}

					}
				}
				return true;
			}
		}

		if (palavra.contains(Letras.RR) || palavra.contains(Letras.SS) || palavra.contains(Letras.CH)
				|| palavra.contains(Letras.LH) || palavra.contains(Letras.NH)) {
			return true;
		}

		for (int posicao = 0; posicao < palavra.length(); posicao++) {
			if (posicao + DUAS_LETRAS_SEGUINTE <= palavra.length()) {
				String letra = palavra.charAt(posicao) + "";
				String letraSeguinte = palavra.charAt(posicao + 1) + "";
				String letraAposODigrafo = palavra.charAt(posicao + 2) + "";

				if (temXS(letra, letraSeguinte)) {
					return Arrays.asList(Letras.VOGAIS).contains(letraAposODigrafo);
				}

				if (temGU(letra, letraSeguinte) || temQU(letra, letraSeguinte) || temXC(letra, letraSeguinte)
						|| temSC(letra, letraSeguinte)) {
					return isSeguidoDeEOuI(letraAposODigrafo);
				}

			}
		}
		return false;
	}

	private boolean temDigrafoVocalico(String letra, String letraSeguinte) {
		return Arrays.asList(Letras.VOGAIS).contains(letra)
				&& (letraSeguinte.equals(Letras.M) || letraSeguinte.equals(Letras.N));
	}

	private boolean temSC(String letra, String letraSeguinte) {
		return letra.equals(Letras.S) && letraSeguinte.equals(Letras.C);
	}

	private boolean temXS(String letra, String letraSeguinte) {
		return letra.equals(Letras.X) && letraSeguinte.equals(Letras.S);
	}

	private boolean temXC(String letra, String letraSeguinte) {
		return letra.equals(Letras.X) && letraSeguinte.equals(Letras.C);
	}

	private boolean temQU(String letra, String letraSeguinte) {
		return letra.equals(Letras.Q) && letraSeguinte.equals(Letras.U);
	}

	private boolean temGU(String letra, String letraSeguinte) {
		return letra.equals(Letras.G) && letraSeguinte.equals(Letras.U);
	}

	private boolean isSeguidoDeEOuI(String vogalAposODigrafo) {
		return vogalAposODigrafo.equals(Letras.E) || vogalAposODigrafo.equalsIgnoreCase(Letras.I);
	}

	public List<String> encontrarDigrafos(String palavra) {
		List<String> possiveisDigrafos = new ArrayList<>();
		for (String digrafo : Arrays.asList(Letras.DIGRAFOS)) {
			if (palavra.contains(digrafo)) {
				possiveisDigrafos.add(digrafo);
			}
		}
		return possiveisDigrafos;
	}

}
