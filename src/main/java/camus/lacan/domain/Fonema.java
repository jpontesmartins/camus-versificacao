package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.services.SepararPalavra;
import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class Fonema {

	public static void main(String args[]) {
		Fonema f = new Fonema();
		String palavra = "indolência";
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
			String letraAnterior = "";

			if (posicao < palavra.length() - 1) {
				letraSeguinte = palavra.charAt(posicao + 1) + "";
			}
			if (posicao > 0) {
				letraAnterior = palavra.charAt(posicao - 1) + "";
			}

			if (isDigrafo(letra, letraSeguinte)) {
				fonemas.add(pegarFonemaDigrafo(letra, letraSeguinte));
			} else if (isConsoanteSimples(letra)) {
				fonemas.add(pegarFonemaDaConsoanteSimples(letra, letraSeguinte));
			} else if (Letras.C.equalsIgnoreCase(letra)) {
				fonemas.add(regrasDoC(letraSeguinte));
			} else if (Letras.S.equals(letra) && !isDigrafo(letra, letraAnterior)) {
				fonemas.add(regrasDoS(posicao, letraSeguinte, palavra));
			} else if (Letras.G.equals(letra)) {
				fonemas.add(regrasDoG(letraSeguinte));
			} else if (Letras.R.equals(letra)) {
				fonemas.add(regrasDoR(posicao, letraSeguinte, palavra));
			} else if (Letras.N.equals(letra)) {
				if (!isDigrafo(letra, letraSeguinte) && isSomNasalisado(letra, posicao, palavra, letraSeguinte)) {
					fonemas.set(fonemas.size() - 1, regrasDoN(palavra, posicao, letraSeguinte));
				} else {
					fonemas.add(regrasDoN(palavra, posicao, letraSeguinte));
				}
			} else if (Letras.M.equals(letra)) {
				if (isSomNasalisado(letraAnterior, posicao, palavra, letraSeguinte)) {
					fonemas.set(fonemas.size() - 1, regrasDoM(palavra, posicao, letraSeguinte));
				} else {
					fonemas.add(regrasDoM(palavra, posicao, letraSeguinte));
				}

			} else if (Letras.isVogal(letra)) {
				fonemas.add(pegarFonemaDaVogal(letra, palavra, posicao));
			} else if (Letras.X.equals(letra)) {
				// TODO: a implementar ainda
				// fonemas.add(regrasDoX(palavra, posicao, letraSeguinte));
			} else if (Letras.CC.equals(letra)) {
				fonemas.add(Fonemas.S);
			}
		}

		return fonemas;
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

	private String regrasDoM(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0)
			return Fonemas.M;
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.isVogal(letraAnterior) && Letras.isVogal(letraSeguinte)) {
			return Fonemas.M;
		}
		if (posicao == palavra.length() - 1) {
			// TODO: ver qual é a vogal anterior para substituir pelo símbolo
			// válido
			return "/~i/";
		}
		return "";
	}

	private String regrasDoN(String palavra, int posicao, String letraSeguinte) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior)
					&& (Letras.isConsoante(letraSeguinte) || posicao == palavra.length() - 1)) {
				if (Letras.A.equals(letraAnterior)) {
					return Fonemas.AN;
				} else if (isLetraE(letraAnterior)) {
					return Fonemas.EN;
				} else if (Letras.I.equals(letraAnterior)) {
					return Fonemas.IN;
				} else if (Letras.O.equals(letraAnterior)) {
					return Fonemas.ON;
				} else if (Letras.U.equals(letraAnterior)) {
					return Fonemas.UN;
				}
			}
			return Fonemas.N;
		}
		return Fonemas.N;
	}

	private String regrasDoS(int posicao, String letraSeguinte, String palavra) {
		if (posicao == 0 || posicao == palavra.length() - 1)
			return Fonemas.S;
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.isVogal(letraSeguinte) && Letras.isVogal(letraAnterior)) {
			return Fonemas.Z;
		}
		return Fonemas.S;
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
		if (Letras.A.equals(letraSeguinte) || isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}
		// TODO: som do X como S....
		// auxílio, próximo, sintaxe, trouxe
		if (isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}

		return "retorno";
	}

	private String pegarFonemaDigrafo(String letra, String letraSeguinte) {
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

	private boolean isDigrafo(String letra, String letraSeguinte) {
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

	private String pegarFonemaDaConsoanteSimples(String letra, String letraSeguinte) {
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

	private String pegarFonemaDaVogal(String letra, String palavra, int posicao) {
		if (Letras.A.equals(letra) || Letras.A_TIL.equals(letra) || Letras.A_ACENTO.equals(letra))
			return pegarFonemaDeA(palavra, posicao, letra);
		if (isLetraE(letra))
			return pegarFonemaDeE(palavra, posicao);
		if (Letras.O.equals(letra))
			return pegarFonemasDeO(palavra, posicao, letra); // TODO
		if (Letras.I.equals(letra)) {
			return pegarFonemasDeI(palavra, posicao, letra);
		}
		if (Letras.U.equals(letra)) {
			return regrasDoU(letra, palavra, posicao);
		}
		return "";
	}

	private boolean isLetraE(String letra) {
		return Letras.E.equals(letra) || Letras.E_CIRC.equals(letra);
	}

	private String pegarFonemasDeI(String palavra, int posicao, String letra) {
		if (posicao == palavra.length() - 1) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior)) {
				return Fonemas.Y;
			}
		}
		return Fonemas.I;
	}

	private String pegarFonemasDeO(String palavra, int posicao, String letra) {
		if (posicao == 0) {
			return Fonemas.O;
		}
		String letraAnterior = palavra.charAt(posicao - 1) + "";

		if (Letras.H.equals(letraAnterior) && posicao - 1 == 0) {
			return Fonemas.O;
		}

		if (posicao == palavra.length() - 1 && Letras.isConsoante(letraAnterior)) {
			return Fonemas.U;
		}

		if (Letras.A_TIL.equals(letraAnterior) || posicao == palavra.length() - 1) {
			return Fonemas.W;
		}

		return Fonemas.O;
	}

	private String pegarFonemaDeA(String palavra, int posicao, String letra) {
		if (Letras.A_TIL.equals(letra))
			return Fonemas.AN;

		if (posicao < palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			String letraAposM = palavra.charAt(posicao + 2) + "";
			if (Letras.M.equals(letraSeguinte) && !Letras.isVogal(letraAposM)) {
				return Fonemas.AN;
			}
		}
		return Fonemas.A;
	}

	private String pegarFonemaDeE(String palavra, int posicao) {
		// if (posicao == palavra.length() - 1)
		// return Fonemas.Y;
		if (posicao < palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			if (Letras.M.equals(letraSeguinte) || Letras.N.equals(letraSeguinte)) {
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
			if (posicao == palavra.length() - 1 && Letras.isVogal(letraAnterior)) {
				return Fonemas.W;
			}

			if (posicao < palavra.length() - 1) {
				String letraSeguinte = palavra.charAt(posicao + 1) + "";
				if (isLetraE(letraSeguinte)) {
					return "";
				}
			}

		}

		return Fonemas.U;
	}

	private String regrasDoR(int posicao, String letraSeguinte, String palavra) {
		if (posicao == 0)
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
		} else if (isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
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

	public List<String> transcreverFrase(String frase) {
		List<String> palavrasTranscritas = new ArrayList<>();
		String palavras[] = frase.toLowerCase().split(" ");
		for (String palavra : palavras) {
			palavrasTranscritas.add(transcreverPalavra(palavra));
		}
		return palavrasTranscritas;
	}

}
