package camus.lacan.domain.separacao;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.comum.Letras;

public class SepararPalavra {

	public static void main(String args[]) {
		SepararPalavra s = new SepararPalavra();
		System.out.println(s.separar("quarto"));
		
	}

	private String palavra;
	private String palavraSeparada;
	private List<String> silabas;
	String silaba;

	public SepararPalavra() {

	}

	public String separarFrase(String frase) {
		String palavas[] = frase.split(" ");
		String fraseSeparada = "";
		for (String palavra : palavas) {
			fraseSeparada += separar(palavra) + " ";
		}

		return fraseSeparada;
	}

	public String separar(String palavraParaSeparar) {
		this.palavra = palavraParaSeparar.toLowerCase();
		this.silabas = new ArrayList<String>();
		this.palavraSeparada = "";

		int inicioSilaba = 0;

		for (int posicaoLetra = 0; posicaoLetra <= palavra.length() - 1; posicaoLetra++) {
			boolean terminaComSemiVogal = false;
			char letra = palavra.charAt(posicaoLetra);

			if (TratarVogais.isVogal(letra)) {
				silaba = "";
				for (int j = inicioSilaba; j <= posicaoLetra; j++) {
					adicionarLetraNaSilaba(pegarLetraDaPosicao(palavra, j));
				}
				if (!isUltimaLetra(palavraParaSeparar, posicaoLetra)) {
					char letraSeguinte = palavra.charAt(posicaoLetra + 1);
					if (TratarHiatos.isHiato(letra, letraSeguinte, palavra, posicaoLetra)) {
						posicaoLetra = tratarHiato(posicaoLetra);
					} else if (TratarDitongos.isDitongo(letra, letraSeguinte)) {
						posicaoLetra = tratarDitongo(posicaoLetra, letraSeguinte);
						posicaoLetra++;
					}
				}

				if (terminaComSemiVogal && isUltimaLetra(palavra, posicaoLetra)) {
					silabas.set(silabas.size() - 1, silaba);
					terminaComSemiVogal = false;
				} else {
					silabas.add(silaba);
					inicioSilaba = posicaoLetra + 1;
				}

			} else {
				/**
				 * se for consoante Q ou G, validar se é dígrafo ou não
				 * 
				 * 
				 * quarto - não é
				 * quinto - é
				 * queijo - é
				 * quociente - não é
				 * 
				 * 
				 * if (q ou g) -> procurar até a próxima consoante.
				 * qu+a - não é, dois sons
				 * qu+e - é
				 * qu+i - é
				 * qu+o - não é, dois sons
				 * 
				 * 
				 */
				
				
				if (isConsoante(letra) && posicaoLetra > 0) {
					if (isUltimaLetra(palavra, posicaoLetra)) {
						String silabaAnterior = silabas.get(silabas.size() - 1);
						silabaAnterior += letra;
						silabas.set(silabas.size() - 1, silabaAnterior);
					} else {
						char letraSeguinte = palavra.charAt(posicaoLetra + 1);

						if (TratarDigrafos.isDigrafoSeparavel(letra, letraSeguinte)) {
							String silabaAnterior = silabas.get(silabas.size() - 1);
							silabaAnterior += letra;
							silabas.set(silabas.size() - 1, silabaAnterior);
							inicioSilaba = posicaoLetra + 1;
						} else {

							if (!TratarDigrafos.isDigrafoInseparavel(letra, letraSeguinte)
									&& !TratarEncontrosConsonantais.isEncontroConsonantalTerminadoEmLOuR(letra,
											letraSeguinte)) {

								if (TratarEncontrosConsonantais.isEncontroConsonantalSeparavel(letra, letraSeguinte)
										&& silabas.size() > 0) {
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

	private int tratarDitongo(int posicaoLetra, char letraSeguinte) {
		silaba += letraSeguinte;
		if (posicaoLetra < palavra.length() - 2) {
			char letraSeguinte2 = palavra.charAt(posicaoLetra + 2);
			if ((silaba.contains(Letras.QU) || silaba.contains(Letras.GU))&& TratarVogais.isVogal(letraSeguinte2)) {
				adicionarLetraNaSilaba(letraSeguinte2);
				posicaoLetra++;
			}
		}
		return posicaoLetra;
	}

	private int tratarHiato(int posicaoLetra) {
		if (silaba.contains(Letras.QU) || silaba.contains(Letras.GU)) {
			if (!isUltimaLetra(palavra, posicaoLetra)) {
				adicionarLetraNaSilaba(pegarLetraDaPosicao(palavra, posicaoLetra + 1));
			}
			posicaoLetra++;
		}
		return posicaoLetra;
	}

	private char pegarLetraDaPosicao(String palavra, int posicaoLetra) {
		return palavra.charAt(posicaoLetra);
	}

	private void adicionarLetraNaSilaba(char letra) {
		silaba += letra;

	}

	private boolean isUltimaLetra(String palavra, int posicaoLetra) {
		return posicaoLetra == palavra.length() - 1;
	}

	public boolean isConsoante(char letra) {
		return !TratarVogais.isVogal(letra);
	}

}
