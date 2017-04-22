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
	public String UI_ACENTO = "uí";

	public String A_TIL = "ã";
	public String O_TIL = "õ";
	public String E_CIRC = "ê";
	public String A_CIRC = "â";
	public String O_CIRC = "ô";

	public String OUA = "oua";
	public String IUA = "iua";

	public String A_TIMBRE_ABERTO = "a";
	public String E_TIMBRE_ABERTO = "é";
	public String O_TIMBRE_ABERTO = "ó";

	public String E_TIMBRE_FECHADO = "ê";
	public String O_TIMBRE_FECHADO = "ô";
	public String I_TIMBRE_FECHADO = "i";
	public String U_TIMBRE_FECHADO = "u";

	public String VOGAIS_TIMBRES_FECHADOS[] = { E_TIMBRE_FECHADO, O_TIMBRE_FECHADO, I_TIMBRE_FECHADO,
			U_TIMBRE_FECHADO };

	public String DITONGOS_[] = { OUA, IUA };
	public String DIGRAFOS_SEPARAVEIS[] = { RR, SS, SC, SCC, XC };
	public String DIGRAFOS_INSEPARAVEIS[] = { GU, QU, LH, NH, CH, PR };
	public String DIGRAFOS_VOGAIS_NASAIS[] = { AM, EM, IM, OM, UM, AN, EN, IN, ON, UN };
	public String HIATOS[] = { AA, EE, II, OO, UU, EA, IA, IO, OA, UA, OE, OE_ACENTO, AU_ACENTO, AE_ACENTO, AI_ACENTO,
			OI_ACENTO, UI_ACENTO };

	public String VOGAIS[] = { A, E, I, O, U, A_ACENTO, E_ACENTO, I_ACENTO, O_ACENTO, U_ACENTO, A_TIL, O_TIL, A_CIRC,
			E_CIRC, O_CIRC };

	public static void main(String[] args) {
		SepararPalavra separarPalavra = new SepararPalavra();
		System.out.println(separarPalavra.separar("juiz"));
		// System.out.println(separarPalavra.separar("queira"));
		// System.out.println(separarPalavra.separar("quatro"));
		// System.out.println(separarPalavra.separar("ergueu"));
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
								if (silaba.contains(QU) || silaba.contains(GU)) {
									char letraSeguinte2 = palavra.charAt(posicaoLetra + 2);
									if (isVogal(letraSeguinte2)) {
										silaba += letraSeguinte2;
										posicaoLetra++;
									}
								}
							}
							posicaoLetra++;
						}
					} else {
						//se fo um hiato....
						if (silaba.contains(QU) || silaba.contains(GU)) {
							if (posicaoLetra + 1 < palavra.length() - 1)
								silaba += palavra.charAt(posicaoLetra + 1);
							posicaoLetra++;
						}
					}

				} else if (posicaoLetra == palavra.length() - 1) {

					if (Arrays.asList(VOGAIS_TIMBRES_FECHADOS).contains("" + palavra.charAt(posicaoLetra))) {
						String silabaAnterior = silabas.get(silabas.size() - 1);
						silaba = silabaAnterior + "" + silaba;
						finalComSemiVogal = true;
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

	private boolean isHiato(char letra, char letraSeguinte, String palavra, int posicaoLetra) {
		String hiato = letra + "" + letraSeguinte;
		List<String> hiatos = Arrays.asList(HIATOS);
		
		boolean regrasDoU = false;
		if (letra == U.charAt(0)) {
//			System.out.println("regras do U");
			if (letraSeguinte == 'i') {
				if (posicaoLetra+2 == palavra.length()-1 && 
						(palavra.charAt(posicaoLetra+2) == 'z' || palavra.charAt(posicaoLetra+2) == 'r'
						|| palavra.charAt(posicaoLetra+2) == 'm')) {
					System.out.println("regras do U+I+Z");
					regrasDoU = true;
				}
				//TODO: rU-Ir, (ultima silaba, penúltima letra)
				// rU-Im
				
				
				
				
				
			}
			
		}
		return hiatos.contains(hiato) || regrasDoU;
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

	public boolean isDuasSilabasTonicas(String ultimaSilabaDaLista, String primeiraSilaba) {
		String elisao = ultimaSilabaDaLista + "" + primeiraSilaba;
		for (String ditongo : DITONGOS_) {
			if (elisao.contains(ditongo))
				return true;
		}
		return false;
	}

}
