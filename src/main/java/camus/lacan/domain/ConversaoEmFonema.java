package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.fonemas.RegrasDosFonemas;
import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

//TODO: essa classe deve ser refatorada
public class ConversaoEmFonema {

	public String transcreverPalavra(String palavra) {
		palavra = palavra.toLowerCase();
		String palavraTranscrita = "";
		for (Fonema fonema : listarFonemasDaPalavra(palavra)) {
			if (!"".equals(fonema.getFonema())) {
				palavraTranscrita += fonema.getFonema() + " ";
			}
		}
		return palavraTranscrita.trim();
	}

	public List<Fonema> listarFonemasDaPalavra(String palavra) {
		List<Fonema> fonemas = new ArrayList<>();

		for (int posicao = 0; posicao < palavra.length(); posicao++) {
			String letra = palavra.charAt(posicao) + "";
			String letraSeguinte = "";
			String letraAnterior = "";

			if (posicao < palavra.length() - 1) {
				letraSeguinte = palavra.charAt(posicao + 1) + "";
			}
			if (posicao > 0) {
				letraAnterior = palavra.charAt(posicao - 1) + "";
			}

			if (isDigrafo(letra, letraSeguinte)) {
				Fonema f = new Fonema(letra + "" + letraSeguinte, pegarFonemaPorDigrafo(letra, letraSeguinte));
				fonemas.add(f);
			} else if (isConsoanteSimples(letra)) {
				Fonema f = new Fonema(letra, pegarFonemaDeConsoanteSimples(letra, letraSeguinte));
				fonemas.add(f);
			} else if (Letras.C.equalsIgnoreCase(letra)) {
				Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoC(letraSeguinte));
				fonemas.add(f);
			} else if (Letras.S.equals(letra) && !isDigrafo(letra, letraAnterior)) {
				Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoS(posicao, letraSeguinte, palavra));
				fonemas.add(f);
			} else if (Letras.G.equals(letra)) {
				Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoG(letraSeguinte));
				fonemas.add(f);
			} else if (Letras.R.equals(letra)) {
				Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoR(posicao, letraSeguinte, palavra));
				fonemas.add(f);
			} else if (Letras.N.equals(letra)) {
				if (!isDigrafo(letra, letraSeguinte) && isSomNasalisado(letra, posicao, palavra, letraSeguinte)) {
					Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoN(palavra, posicao, letraSeguinte));
					fonemas.add(f);
				} else {
					Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoN(palavra, posicao, letraSeguinte));
					fonemas.add(f);
				}
			} else if (Letras.M.equals(letra)) {
				if (isSomNasalisado(letraAnterior, posicao, palavra, letraSeguinte)) {
					fonemas.set(fonemas.size() - 1, new Fonema(letraAnterior + letra,
							RegrasDosFonemas.regrasDoM(palavra, posicao, letraSeguinte)));
				} else {
					Fonema f = new Fonema(letra, RegrasDosFonemas.regrasDoM(palavra, posicao, letraSeguinte));
					fonemas.add(f);
				}
			} else if (Letras.isVogal(letra)) {
				Fonema f = new Fonema(letra, pegarFonemaDeVogal(letra, palavra, posicao));
				fonemas.add(f);
			} else if (Letras.X.equals(letra)) {
				// TODO: a implementar ainda
				// fonemas.add(regrasDoX(palavra, posicao, letraSeguinte));
			} else if (Letras.CC.equals(letra)) {
				Fonema f = new Fonema(letra, Fonemas.S);
				fonemas.add(f);
			}
		}

		fonemas.removeIf(p -> p.getFonema().isEmpty());
		return fonemas;
	}

	public static boolean isDigrafo(String letra, String letraSeguinte) {
		if ("".equals(letraSeguinte))
			return false;
		return Letras.QU.equals(letra + "" + letraSeguinte) || Letras.CH.equals(letra + "" + letraSeguinte)
				|| Letras.NH.equals(letra + "" + letraSeguinte) || Letras.LH.equals(letra + "" + letraSeguinte)
				|| Letras.SS.equals(letra + "" + letraSeguinte);
	}

	private boolean isConsoanteSimples(String letra) {
		return Letras.B.equals(letra) || Letras.D.equals(letra) || Letras.F.equals(letra) || Letras.P.equals(letra)
				|| Letras.Z.equals(letra) || Letras.L.equals(letra) || Letras.J.equals(letra) || Letras.T.equals(letra)
				|| Letras.V.equals(letra);
	}

	private boolean isSomNasalisado(String letra, int posicao, String palavra, String letraSeguinte) {
		if (posicao == palavra.length() - 1)
			return true;
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			return Arrays.asList(Letras.VOGAIS_NASALISADAS).contains(letraAnterior + letra)
					&& !Letras.isVogal(letraSeguinte);
		}
		return false;
	}

	private String pegarFonemaDeConsoanteSimples(String letra, String letraSeguinte) {
		if (Letras.B.equals(letra)) {
			return Fonemas.B;
		} else if (Letras.D.equals(letra)) {
			return Fonemas.D;
		} else if (Letras.F.equals(letra)) {
			return Fonemas.F;
		} else if (Letras.P.equals(letra)) {
			return Fonemas.P;
		} else if (Letras.Z.equals(letra)) {
			return Fonemas.Z;
		} else if (Letras.L.equals(letra) && !isDigrafo(letra, letraSeguinte)) {
			return Fonemas.L;
		} else if (Letras.J.equals(letra)) {
			return Fonemas.J;
		} else if (Letras.T.equals(letra)) {
			return Fonemas.T;
		} else if (Letras.V.equals(letra)) {
			return Fonemas.V;
		}

		return "";
	}

	private String pegarFonemaDeVogal(String letra, String palavra, int posicao) {
		if (Letras.isLetraA(letra))
			return RegrasDosFonemas.regraDoA(palavra, posicao, letra);
		if (Letras.isLetraE(letra))
			return RegrasDosFonemas.regraDoE(palavra, posicao, letra);
		if (Letras.O.equals(letra))
			return RegrasDosFonemas.regraDeO(palavra, posicao, letra);
		if (Letras.I.equals(letra)) {
			return RegrasDosFonemas.regrasDoI(palavra, posicao, letra);
		}
		if (Letras.U.equals(letra) || Letras.U_ACENTO.equals(letra)) {
			return RegrasDosFonemas.regrasDoU(letra, palavra, posicao);
		}
		return "";
	}

	private String pegarFonemaPorDigrafo(String letra, String letraSeguinte) {
		if (Letras.QU.equals(letra + "" + letraSeguinte)) {
			return Fonemas.K;
		} else if (Letras.CH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.X;
		} else if (Letras.NH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.NH;
		} else if (Letras.LH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.LH;
		} else if (Letras.SS.equals(letra + "" + letraSeguinte)) {
			return Fonemas.S;
		} else if (Letras.XC.equals(letra + "" + letraSeguinte)) {
			return Fonemas.S;
		}
		return "";
	}
}


