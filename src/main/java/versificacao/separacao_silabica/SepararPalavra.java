package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import versificacao.utils.Letras;

public class SepararPalavra {

	public String separarFrase(String frase) {
		String palavas[] = frase.split(" ");
		String fraseSeparada = "";
		for (String palavra : palavas) {
			fraseSeparada += separar(palavra) + " ";
		}

		return fraseSeparada;
	}

	public String separar(String palavraParaSeparar) {
		String palavra = palavraParaSeparar.toLowerCase();
		int inicioSilaba = 0;
		String palavraSeparada = "";
		List<String> silabas = new ArrayList<String>();
		for (int posicaoLetra = 0; posicaoLetra <= palavra.length() - 1; posicaoLetra++) {
			boolean finalComSemiVogal = false;
			char letra = palavra.charAt(posicaoLetra);
			if (isVogal(letra)) {

				String silaba = "";
				for (int j = inicioSilaba; j <= posicaoLetra; j++) {
					silaba += palavra.charAt(j);
				}

				if (posicaoLetra < palavra.length() - 1) {
					char letraSeguinte = palavra.charAt(posicaoLetra + 1);

					if (!isHiato(letra, letraSeguinte, palavra, posicaoLetra)) {

						if (isDitongo(letra, letraSeguinte)) {
							silaba += letraSeguinte;
							if (posicaoLetra < palavra.length() - 2) {
								char letraSeguinte2 = palavra.charAt(posicaoLetra + 2);
								if ((silaba.contains(Letras.QU) || silaba.contains(Letras.GU))
										&& isVogal(letraSeguinte2)) {
									silaba += letraSeguinte2;
									posicaoLetra++;

								}
							}
							posicaoLetra++;
						}
					} else {
						// se fo um hiato....
						if (silaba.contains(Letras.QU) || silaba.contains(Letras.GU)) {
							if (posicaoLetra + 1 < palavra.length() - 1)
								silaba += palavra.charAt(posicaoLetra + 1);
							posicaoLetra++;
						}
					}

				}

				if (posicaoLetra == palavra.length() - 1 && finalComSemiVogal) {
					silabas.set(silabas.size() - 1, silaba);
					finalComSemiVogal = false;
				} else {
					silabas.add(silaba);
					inicioSilaba = posicaoLetra + 1;
				}

			} else {
				if (isConsoante(letra) && posicaoLetra > 0) {
					if (posicaoLetra == palavra.length() - 1) {
						String silabaAnterior = silabas.get(silabas.size() - 1);
						silabaAnterior += letra;
						silabas.set(silabas.size() - 1, silabaAnterior);
					} else {
						char letraSeguinte = palavra.charAt(posicaoLetra + 1);

						if (isDigrafoSeparavel(letra, letraSeguinte)) {
							String silabaAnterior = silabas.get(silabas.size() - 1);
							silabaAnterior += letra;
							silabas.set(silabas.size() - 1, silabaAnterior);
							inicioSilaba = posicaoLetra + 1;
						} else {

							if (!isDigrafoInseparavel(letra, letraSeguinte)
									&& !isEncontroConsonantalTerminadoEmLOuR(letra, letraSeguinte)) {

								if (isEncontroConsonantalSeparavel(letra, letraSeguinte) && silabas.size() > 0) {
									String silabaAnterior = silabas.get(silabas.size() - 1);
									silabaAnterior += letra;
									silabas.set(silabas.size() - 1, silabaAnterior);
									inicioSilaba = posicaoLetra + 1;
								}

							}

						}
					}
				}

			}
		}

		for (String silaba : silabas) {
			palavraSeparada += silaba + " ";
		}

		return palavraSeparada.trim();
	}

	private boolean isHiato(char letra, char letraSeguinte, String palavra, int posicaoLetra) {
		String hiato = letra + "" + letraSeguinte;
		List<String> hiatos = Arrays.asList(Letras.HIATOS);

		boolean regrasDoU = false;
		if (Letras.U.equals(letra + "") && Letras.I.equals(letraSeguinte + "") && posicaoLetra + 2 < palavra.length()) {
				String ultimaLetra = "" + palavra.charAt(posicaoLetra + 2);
				String consoantesFinais[] = { Letras.Z, Letras.R, Letras.M };
				if (isUltimaLetra(palavra, posicaoLetra) && Arrays.asList(consoantesFinais).contains(ultimaLetra)) {
					regrasDoU = true;
				}
				// TODO: rU-Ir, (ultima silaba, penúltima letra)
				// rU-Im
		}
		return hiatos.contains(hiato) || regrasDoU;
	}

	private boolean isUltimaLetra(String palavra, int posicaoLetra) {
		return posicaoLetra + 2 == palavra.length() - 1;
	}

	private boolean isEncontroConsonantalTerminadoEmLOuR(char letra, char letraSeguinte) {
		return isConsoante(letra) && (letraSeguinte == 'l' || letraSeguinte == 'r');
	}

	private boolean isDitongo(char letra, char letraSeguinte) {
		return isVogal(letra) && isVogal(letraSeguinte);
	}

	private boolean isEncontroConsonantalSeparavel(char letra, char letraSeguinte) {
		return !(isConsoante(letra) && isVogal(letraSeguinte));
	}

	private boolean isDigrafoInseparavel(char letra, char letraSeguinte) {
		String digrafo = letra + "" + letraSeguinte;
		List<String> digrafosInseparaveis = Arrays.asList(Letras.DIGRAFOS_INSEPARAVEIS);
		return (digrafosInseparaveis.contains(digrafo));
	}

	private boolean isDigrafoSeparavel(char letra, char letraSeguinte) {
		String encontroConsonantal = letra + "" + letraSeguinte;
		List<String> digrafos = Arrays.asList(Letras.DIGRAFOS_SEPARAVEIS);
		return (digrafos.contains(encontroConsonantal));
	}

	public boolean isVogal(char letra) {
		String letraComoString = ("" + letra).toLowerCase();
		List<String> vogais = Arrays.asList(Letras.VOGAIS);
		return (vogais.contains(letraComoString));
	}

	public boolean isConsoante(char letra) {
		return !isVogal(letra);
	}

	public boolean isDuasSilabasTonicas(String ultimaSilabaDaLista, String primeiraSilaba) {
		String elisao = ultimaSilabaDaLista + "" + primeiraSilaba;
		for (String ditongo : Letras.DITONGOS_) {
			if (elisao.contains(ditongo))
				return true;
		}
		return false;
	}

}
