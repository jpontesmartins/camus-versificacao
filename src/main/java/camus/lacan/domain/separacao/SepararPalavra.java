package camus.lacan.domain.separacao;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.comum.Letras;

public class SepararPalavra {
	
	private String palavra;
	private String palavraSeparada;
	private List<String> silabas;
	
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
			boolean finalComSemiVogal = false;
			char letra = palavra.charAt(posicaoLetra);
			if (TratarVogais.isVogal(letra)) {
				String silaba = "";
				for (int j = inicioSilaba; j <= posicaoLetra; j++) {
					silaba += palavra.charAt(j);
				}
				if (posicaoLetra < palavra.length() - 1) {
					char letraSeguinte = palavra.charAt(posicaoLetra + 1);
					if (TratarHiatos.isHiato(letra, letraSeguinte, palavra, posicaoLetra)) {
						if (silaba.contains(Letras.QU) || silaba.contains(Letras.GU)) {
							if (posicaoLetra + 1 < palavra.length() - 1)
								silaba += palavra.charAt(posicaoLetra + 1);
							posicaoLetra++;
						}
					} else if (TratarDitongos.isDitongo(letra, letraSeguinte)) {
						silaba += letraSeguinte;
						if (posicaoLetra < palavra.length() - 2) {
							char letraSeguinte2 = palavra.charAt(posicaoLetra + 2);
							if ((silaba.contains(Letras.QU) || silaba.contains(Letras.GU))
									&& TratarVogais.isVogal(letraSeguinte2)) {
								silaba += letraSeguinte2;
								posicaoLetra++;
							}
						}
						posicaoLetra++;
					}
				}

				if (isUltimaLetra(palavra, posicaoLetra) && finalComSemiVogal) {
					silabas.set(silabas.size() - 1, silaba);
					finalComSemiVogal = false;
				} else {
					silabas.add(silaba);
					inicioSilaba = posicaoLetra + 1;
				}

			} else {
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

	private boolean isUltimaLetra(String palavra, int posicaoLetra) {
		return posicaoLetra == palavra.length() - 1;
	}

	public boolean isConsoante(char letra) {
		return !TratarVogais.isVogal(letra);
	}

}
