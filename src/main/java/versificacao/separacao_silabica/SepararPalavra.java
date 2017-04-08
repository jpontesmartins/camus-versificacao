package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SepararPalavra {

	public String RR = "rr";
	public String SS = "ss";
	public String SC = "sc";
	public String SCC = "sç";
	public String XC = "xc";
	public String CH = "ch";
	public String LH = "lh";
	public String NH = "nh";
	public String PT = "pt";
	public String FT = "ft";
	public String TR = "tr";
	public String CL = "cl";
	public String DR = "dr";
	public String CR = "cr";
	public String GU = "gu";
	public String QU = "qu";
	public String AM = "am";
	public String EM = "em";
	public String IM = "im";
	public String OM = "om";
	public String UM = "um";
	public String AN = "an";
	public String EN = "en";
	public String IN = "in";
	public String ON = "on";
	public String UN = "un";
	public String PR = "pr";

	public String DIGRAFOS_SEPARAVEIS[] = { RR, SS, SC, SCC, XC };
	public String DIGRAFOS_INSEPARAVEIS[] = { GU, QU, LH, NH, CH, PR };
	public String DIGRAFOS_VOGAIS_NASAIS[] = { AM, EM, IM, OM, UM, AN, EN, IN, ON, UN };

	public static void main(String[] args) {
		SepararPalavra separarPalavra = new SepararPalavra();
		System.out.println(separarPalavra.separar("isqueiro"));
		// System.out.println(separarPalavra.separarFrase("os ombros suportam o
		// mundo"));
		// System.out.println(separarPalavra.separarFrase("Tempo de absoluta
		// depuração"));

	}

	public String separarFrase(String frase) {
		String palavas[] = frase.split(" ");
		String fraseSeparada = "";
		for (String palavra : palavas) {
			fraseSeparada += separar(palavra) + " ";
		}

		return fraseSeparada;
	}

	public String separar(String palavra) {
		palavra = palavra.toLowerCase();
		int inicioSilaba = 0;
		String palavraSeparada = "";
		List<String> silabas = new ArrayList<String>();
		for (int posicaoLetra = 0; posicaoLetra <= palavra.length() - 1; posicaoLetra++) {
			char letra = palavra.charAt(posicaoLetra);
			if (isVogal(letra)) {

				// if (ultimaSilabaTemDigrafoInseparavelEDitongo())

				String silaba = "";
				for (int j = inicioSilaba; j <= posicaoLetra; j++) {
					silaba += palavra.charAt(j);
				}

				if (posicaoLetra < palavra.length() - 1) {
					char letraSeguinte = palavra.charAt(posicaoLetra + 1);
					if (isDitongo(letra, letraSeguinte)) {
						silaba += letraSeguinte;

//						System.out.println("aqui tem um ditongo");

						if (posicaoLetra < palavra.length() - 2) {
							if (silaba.contains(QU)) {
								char letraSeguinte2 = palavra.charAt(posicaoLetra + 2);
								if (isVogal(letraSeguinte2)) {
									silaba += letraSeguinte2;
									posicaoLetra++;
								}
							}
						}
						posicaoLetra++;
					}

				}

				silabas.add(silaba);
				inicioSilaba = posicaoLetra + 1;

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
							if (isDigrafoInseparavel(letra, letraSeguinte)
									|| isEncontroConsonantalTerminadoEmLOuR(letra, letraSeguinte)) {
							} else {
								if (isEncontroConsonantalSeparavel(letra, letraSeguinte)) {
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

	private boolean isEncontroConsonantalTerminadoEmLOuR(char letra, char letraSeguinte) {
		return isConsoante(letra) && (letraSeguinte == 'l' || letraSeguinte == 'r');
	}

	private boolean isDitongo(char letra, char letraSeguinte) {
		return isVogal(letra) && isVogal(letraSeguinte);
	}

	private boolean isEncontroConsonantalSeparavel(char letra, char letraSeguinte) {
		if (isConsoante(letra) && isVogal(letraSeguinte))
			return false;
		return true;
	}

	private boolean isDigrafoInseparavel(char letra, char letraSeguinte) {
		String digrafo = letra + "" + letraSeguinte;
		List<String> digrafosInseparaveis = Arrays.asList(DIGRAFOS_INSEPARAVEIS);
		if (digrafosInseparaveis.contains(digrafo)) {
			return true;
		}
		return false;
	}

	private boolean isDigrafoSeparavel(char letra, char letraSeguinte) {
		String encontroConsonantal = letra + "" + letraSeguinte;
		List<String> digrafos = Arrays.asList(DIGRAFOS_SEPARAVEIS);
		if (digrafos.contains(encontroConsonantal)) {
			return true;
		}
		return false;
	}

	public boolean isVogal(char letra) {
		String letraComoString = ("" + letra).replace('ã', 'a').replace('é', 'e').replace('á', 'a').replace('í', 'i');
		letra = letraComoString.charAt(0);
		if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' || letra == 'a' || letra == 'e'
				|| letra == 'i' || letra == 'o' || letra == 'u') {
			return true;
		}
		return false;
	}

	public boolean isConsoante(char letra) {
		return !isVogal(letra);
	}

}
