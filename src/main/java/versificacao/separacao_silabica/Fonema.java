package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.List;

import versificacao.utils.Fonemas;
import versificacao.utils.Letras;

public class Fonema {

	public static void main(String args[]) {
		Fonema f = new Fonema();
		String palavra = "rolha";
		System.out.println(f.transcreverPalavra(palavra));
	}

	public String transcreverPalavra(String palavra) {
		String palavraTranscrita = "";
		for (String fonema : descobrirFonemasDaPalavra(palavra)) {
			if (!"".equals(fonema)) {
				palavraTranscrita += fonema + " ";
			}
		}
		return palavraTranscrita.trim();
	}

	public List<String> descobrirFonemasDaPalavra(String palavra) {
		List<String> fonemas = new ArrayList<>();
		for (int posicao = 0; posicao < palavra.length(); posicao++) {
			String letra = palavra.charAt(posicao) + "";
			String letraSeguinte = "";
			if (posicao < palavra.length() - 1) {
				letraSeguinte = palavra.charAt(posicao + 1) + "";
			}

			if (isDigrafo(letra, letraSeguinte)) {
				fonemas.add(fonemaDigrafos(fonemas, letra, letraSeguinte));
			}

			if (isConsoanteSimples(letra)) {
				fonemas.add(fonemaConsoanteSimples(letra, letraSeguinte));
			}

			if (Letras.C.equalsIgnoreCase(letra)) {
				fonemas.add(regrasDoC(letraSeguinte));
			}

			if (Letras.S.equals(letra)) {
				fonemas.add(regrasDoS(posicao, letra, letraSeguinte, palavra));
			}

			if (Letras.G.equals(letra)) {
				fonemas.add(regrasDoG(letraSeguinte));
			}

			if (Letras.R.equals(letra)) {
				fonemas.add(regrasDoR(posicao, letraSeguinte, palavra));
			}

			if (Letras.N.equals(letra) && !isDigrafo(letra, letraSeguinte)) {
				fonemas.set(fonemas.size() - 1, regrasDoN(palavra, fonemas, posicao, letraSeguinte));
			}

			if (Letras.M.equals(letra)) {
				fonemas.add(regrasDoM(palavra, posicao, letraSeguinte));
			}

			if (Letras.isVogal(letra)) {
				fonemas.add(fonemaDaVogal(letra, palavra, posicao));
			}

			if (Letras.X.equals(letra)) {
				// TODO: a implementar ainda
				// fonemas.add(regrasDoX(palavra, posicao, letraSeguinte));
			}

		}

		return fonemas;
	}

	private String regrasDoM(String palavra, int posicao, String letraSeguinte) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior) && Letras.isVogal(letraSeguinte)) {
				return Fonemas.M;
			}
		}
		return "";
	}

	private String regrasDoN(String palavra, List<String> fonemas, int posicao, String letraSeguinte) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior)
					&& (Letras.isConsoante(letraSeguinte) || posicao == palavra.length() - 1)) {
				if (Letras.A.equals(letraAnterior)) {
					return Fonemas.AN;
				} else if (Letras.E.equals(letraAnterior)) {
					return Fonemas.EN;
				} else if (Letras.I.equals(letraAnterior)) {
					return Fonemas.IN;
				} else if (Letras.O.equals(letraAnterior)) {
					return Fonemas.ON;
				} else if (Letras.U.equals(letraAnterior)) {
					return Fonemas.UN;
				}
			}
		}
		return "";
	}

	private String regrasDoS(int posicao, String letra, String letraSeguinte, String palavra) {
		if (posicao == 0 || posicao == palavra.length() - 1)
			return Fonemas.S;
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.isVogal(letraSeguinte) && Letras.isVogal(letraAnterior)) {
			return Fonemas.Z;
		}
		return Fonemas.S;
	}

	public String converterEmFonema(String palavra) {
		return descobrirFonemasDaPalavra(palavra).get(0);

	}

	public String converterEmFonema2(String palavra) {
		return descobrirFonemasDaPalavra(palavra).get(1);

	}

	private String regrasDoX(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0)
			return Fonemas.X;

		if (posicao > 1) {
			SepararPalavra separarPalavra = new SepararPalavra();
			separarPalavra.separar(palavra);
			Ditongo ditongo = new Ditongo();
			List<String> ditongos = ditongo.pegarDitongos(palavra);

			if (!ditongos.isEmpty()) {
				return Fonemas.X;
			}
		}

		// exato, existir, executar
		if (Letras.A.equals(letraSeguinte) || Letras.E.equals(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}
		// TODO: som do X como S....
		// auxílio, próximo, sintaxe, trouxe
		if (Letras.E.equals(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}

		return "retorno";
	}

	private String fonemaDigrafos(List<String> fonemas, String letra, String letraSeguinte) {
		if (Letras.QU.equals(letra + "" + letraSeguinte)) {
			return Fonemas.K;
		}
		if (Letras.CH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.X;
		}
		if (Letras.NH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.NH;
		}
		if (Letras.LH.equals(letra + "" + letraSeguinte)) {
			return Fonemas.LH;
		}
		if (Letras.SS.equals(letra + "" + letraSeguinte)) {
			return Fonemas.S;
		}
		if (Letras.XC.equals(letra + "" + letraSeguinte)) {
			return Fonemas.S;
		}
		return "";
	}

	private boolean isDigrafo(String letra, String letraSeguinte) {
		if ("".equals(letraSeguinte))
			return false;
		return Letras.QU.equals(letra + "" + letraSeguinte) || Letras.CH.equals(letra + "" + letraSeguinte)
				|| Letras.NH.equals(letra + "" + letraSeguinte) || Letras.LH.equals(letra + "" + letraSeguinte)
				|| Letras.SS.equals(letra + "" + letraSeguinte);
	}

	private boolean isConsoanteSimples(String letra) {
		return Letras.B.equals(letra) || Letras.D.equals(letra) || Letras.F.equals(letra) || Letras.P.equals(letra)
				|| Letras.Z.equals(letra) || Letras.L.equals(letra) || Letras.J.equals(letra) || Letras.T.equals(letra);
	}

	private String fonemaConsoanteSimples(String letra, String letraSeguinte) {
		if (Letras.B.equals(letra))
			return Fonemas.B;
		if (Letras.D.equals(letra))
			return Fonemas.D;
		if (Letras.F.equals(letra))
			return Fonemas.F;
		if (Letras.P.equals(letra))
			return Fonemas.P;
		if (Letras.Z.equals(letra))
			return Fonemas.Z;
		if (Letras.L.equals(letra) && !isDigrafo(letra, letraSeguinte))
			return Fonemas.L;
		if (Letras.J.equals(letra))
			return Fonemas.J;
		if (Letras.T.equals(letra))
			return Fonemas.T;

		return "";
	}

	private String fonemaDaVogal(String letra, String palavra, int posicao) {
		if (Letras.A.equals(letra))
			return fonemasDoA(letra, palavra, posicao);
		if (Letras.E.equals(letra))
			return fonemasDoE(letra, palavra, posicao);
		if (Letras.O.equals(letra))
			return Fonemas.O;
		if (Letras.I.equals(letra))
			return Fonemas.I;
		if (Letras.U.equals(letra)) {
			return regrasDoU(letra, palavra, posicao);
		}
		return "";
	}

	private String fonemasDoA(String letra, String palavra, int posicao) {
		if (posicao < palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			String letraAposM = palavra.charAt(posicao + 2) + "";
			if (Letras.M.equals(letraSeguinte) && !Letras.isVogal(letraAposM)) {
				return Fonemas.AN;
			}
		}
		return Fonemas.A;
	}

	private String fonemasDoE(String letra, String palavra, int posicao) {
		if (posicao < palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			if (Letras.M.equals(letraSeguinte)) {
				return Fonemas.EN;
			}
		}
		return Fonemas.E;
	}

	private String regrasDoU(String letra, String palavra, int posicao) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (isDigrafo(letraAnterior, letra) && posicao < palavra.length()) {
				String letraSeguinte = palavra.charAt(posicao + 1) + "";
				if (Letras.A.equals(letraSeguinte) || Letras.O.equals(letraSeguinte)) {
					return Fonemas.W;
				}
			}
		}

		return Fonemas.U;
	}

	private String regrasDoR(int posicao, String letraSeguinte, String palavra) {
		if (posicao == 0 || posicao == palavra.length() - 1)
			return Fonemas.R_MAISCULO;
		if (Letras.R.equals(letraSeguinte) || Letras.isConsoante(letraSeguinte)) {
			return Fonemas.R_MAISCULO;
		}
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.R.equals(letraAnterior)) {
			return "";
		}
		return Fonemas.R;

	}

	private String regrasDoG(String letraSeguinte) {
		if (Letras.U.equals(letraSeguinte)) {
			return Fonemas.G;
		} else if (Letras.E.equals(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.J;
		}
		return Fonemas.G;
	}

	private String regrasDoC(String letraSeguinte) {
		if (Letras.A.equals(letraSeguinte) || Letras.O.equals(letraSeguinte) || Letras.U.equals(letraSeguinte)) {
			return Fonemas.K;
		}
		return Fonemas.S;
	}

}
