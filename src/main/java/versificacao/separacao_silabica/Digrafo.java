package versificacao.separacao_silabica;

import java.util.Arrays;

import versificacao.utils.Letras;

public class Digrafo {

	public static void main(String[] args) {
		Digrafo digrafo = new Digrafo();
		System.out.println(digrafo.contemDigrafo("sc", "desci"));
	}

	private static final Integer DUAS_LETRAS_ADIANTE = 2;

	public Boolean contemDigrafo(String digrafo, String palavra) {
		if (digrafo.equals(Letras.SC)) {
			if (palavra.contains(Letras.SC)) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_ADIANTE <= palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";
						if (contemSC(letra, letraSeguinte)) {
							return isSeguidoDeEOuI(letraAposODigrafo);
						}
					}
				}
			}
		} else if (digrafo.equals(Letras.XS)) {
			if (palavra.contains(Letras.XS)) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_ADIANTE <= palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";
						if (contemXS(letra, letraSeguinte)) {
							return Arrays.asList(Letras.VOGAIS).contains(letraAposODigrafo);
						}
					}
				}
			}
		} else if (digrafo.equals(Letras.XC)) {
			if (palavra.contains(Letras.XC)) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_ADIANTE <= palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";
						if (contemXC(letra, letraSeguinte)) {
							return isSeguidoDeEOuI(letraAposODigrafo);
						}
					}
				}
			}
		} else if (digrafo.equals(Letras.QU)) {
			if (palavra.contains(Letras.QU)) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_ADIANTE <= palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";
						if (contemQU(letra, letraSeguinte)) {
							return isSeguidoDeEOuI(letraAposODigrafo);
						}
					}
				}
			}
		} else if (digrafo.equals(Letras.GU)) {
			if (palavra.contains(Letras.GU)) {
				for (int posicao = 0; posicao < palavra.length(); posicao++) {
					if (posicao + DUAS_LETRAS_ADIANTE <= palavra.length()) {
						String letra = palavra.charAt(posicao) + "";
						String letraSeguinte = palavra.charAt(posicao + 1) + "";
						String letraAposODigrafo = palavra.charAt(posicao + 2) + "";
						if (contemGU(letra, letraSeguinte)) {
							return isSeguidoDeEOuI(letraAposODigrafo);
						}
					}
				}
			}
		}
		return null;
	}

	private boolean contemSC(String letra, String letraSeguinte) {
		return letra.equals(Letras.S) && letraSeguinte.equals(Letras.C);
	}

	private boolean contemXS(String letra, String letraSeguinte) {
		return letra.equals(Letras.X) && letraSeguinte.equals(Letras.S);
	}

	private boolean contemXC(String letra, String letraSeguinte) {
		return letra.equals(Letras.X) && letraSeguinte.equals(Letras.C);
	}

	private boolean contemQU(String letra, String letraSeguinte) {
		return letra.equals(Letras.Q) && letraSeguinte.equals(Letras.U);
	}

	private boolean contemGU(String letra, String letraSeguinte) {
		return letra.equals(Letras.G) && letraSeguinte.equals(Letras.U);
	}

	private boolean isSeguidoDeEOuI(String vogalAposODigrafo) {
		return vogalAposODigrafo.equals(Letras.E) || vogalAposODigrafo.equalsIgnoreCase(Letras.I);
	}

}
