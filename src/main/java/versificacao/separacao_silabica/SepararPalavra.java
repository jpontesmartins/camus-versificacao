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

	public String AA = "aa";
	public String EE = "ee";
	public String II = "ii";
	public String OO = "oo";
	public String UU = "uu";

	public String EA = "ea";
	public String IA = "ia";
	public String IO = "io";
	public String OA = "oa";
	public String OE = "oe";
	public String UA = "ua";

	public String A = "a";
	public String E = "e";
	public String I = "i";
	public String O = "o";
	public String U = "u";

	public String VOGAIS_2[] = { A, E, O };
	public String SEMI_VOGAIS[] = { I, U };

	public String A_ACENTO = "á";
	public String E_ACENTO = "é";
	public String I_ACENTO = "í";
	public String O_ACENTO = "ó";
	public String U_ACENTO = "ú";

	public String AU_ACENTO = "aú";
	public String AE_ACENTO = "aé";
	public String AI_ACENTO = "aí";
	public String OI_ACENTO = "oí";
	public String OE_ACENTO = "oé";

	public String A_TIL = "ã";
	public String O_TIL = "õ";
	public String E_CIRC = "ê";
	public String A_CIRC = "â";
	public String O_CIRC = "ô";
	
	

	public String DIGRAFOS_SEPARAVEIS[] = { RR, SS, SC, SCC, XC };
	public String DIGRAFOS_INSEPARAVEIS[] = { GU, QU, LH, NH, CH, PR };
	public String DIGRAFOS_VOGAIS_NASAIS[] = { AM, EM, IM, OM, UM, AN, EN, IN, ON, UN };
	public String HIATOS[] = { AA, EE, II, OO, UU, EA, IA, IO, OA, UA, OE, OE_ACENTO, AU_ACENTO, AE_ACENTO, AI_ACENTO, OI_ACENTO };

	public String VOGAIS[] = { A, E, I, O, U, A_ACENTO, E_ACENTO, I_ACENTO, O_ACENTO, U_ACENTO, A_TIL, O_TIL, A_CIRC, E_CIRC, O_CIRC };

	public static void main(String[] args) {
		SepararPalavra separarPalavra = new SepararPalavra();
		System.out.println(separarPalavra.separar("saída"));
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

				String silaba = "";
				for (int j = inicioSilaba; j <= posicaoLetra; j++) {
					silaba += palavra.charAt(j);
				}

				if (posicaoLetra < palavra.length() - 1) {
					char letraSeguinte = palavra.charAt(posicaoLetra + 1);

					if (!isHiato(letra, letraSeguinte)) {

						if (isDitongo(letra, letraSeguinte)) {
							silaba += letraSeguinte;
//							System.out.println("aqui tem um ditongo: " + letra + letraSeguinte);
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
									if (silabas.size() > 0) {
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
		}

		for (String silaba : silabas) {
			palavraSeparada += silaba + " ";
		}

		return palavraSeparada.trim();
	}

	private boolean isHiato(char letra, char letraSeguinte) {
		String hiato = letra + "" + letraSeguinte;
		List<String> hiatos = Arrays.asList(HIATOS);
		return hiatos.contains(hiato);
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
		String letraComoString = ("" + letra).toLowerCase();

		List<String> vogais = Arrays.asList(VOGAIS);
		if (vogais.contains(letraComoString))
			return true;

		return false;
	}

	public boolean isConsoante(char letra) {
		return !isVogal(letra);
	}

}
