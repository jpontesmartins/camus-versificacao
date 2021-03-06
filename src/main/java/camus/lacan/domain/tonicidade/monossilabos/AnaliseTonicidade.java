package camus.lacan.domain.tonicidade.monossilabos;

import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.separacao.SepararPalavra;
import camus.lacan.domain.tonicidade.TonicidadeEnum;

import static camus.lacan.domain.tonicidade.Vogais.*;

public class AnaliseTonicidade {

	public String FINAIS_PAROXITONAS[] = { A, O, E, AS, OS, ES };
	public String VOGAIS_ACENTUADAS[] = { A_ACENTO, E_ACENTO, I_ACENTO, O_ACENTO, U_ACENTO, A_CIRC, E_CIRC, O_CIRC };

	public int encontrarTonicidadeDaPalavra(String palavra) {
		String silabaTonica = encontrarSilabaTonica(palavra);
		SepararPalavra separarPalavra = new SepararPalavra();
		String silabas[] = separarPalavra.separar(palavra).split(" ");

		if (silabas.length == 1)
			return distinguirEntreMonossilaboTonicoOuAtono(silabas[0]);

		int posicao = 0;
		for (int i = silabas.length - 1; i >= 0; i--) {
			String silaba = silabas[i];
			if (silabaTonica.equals(silaba)) {
				return posicao + 1;
			}
			posicao++;
		}
		return posicao;
	}

	public int distinguirEntreMonossilaboTonicoOuAtono(String monossilabo) {
		TratamentoMonossilabos monossilabos = new TratamentoMonossilabos(monossilabo);
		return monossilabos.distinguirEntreTonicoEAtono();
	}

	public String encontrarSilabaTonica(String palavra) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String silabas[] = separarPalavra.separar(palavra).split(" ");

		String silabaFinal = silabas[silabas.length - 1];
		if (silabaFinal.length() == 0)
			return "";
		String ultimaLetra = "" + silabaFinal.charAt(silabaFinal.length() - 1);
		int qtdeSilabas = silabas.length;
		String silabaTonica = "";
		String ultimasLetras = "";

		if (contemVogalAcentuada(palavra)) {
			for (int i = 0; i < silabas.length; i++) {
				String silabaAtual = silabas[i];
				if (contemVogalAcentuada(silabaAtual)) {
					return silabaAtual;
				}
			}
		} else {
			if (podeSerParoxitona(qtdeSilabas)) {
				if (ultimaLetra.equals(S) && silabaFinal.length() > 1) {
					ultimasLetras = silabaFinal.charAt(silabaFinal.length() - 2) + "" + ultimaLetra;
				} else {
					ultimasLetras = ultimaLetra;
				}
				if (Arrays.asList(FINAIS_PAROXITONAS).contains(ultimasLetras)) {
					silabaTonica = silabas[qtdeSilabas - 2];
					return silabaTonica.trim(); // a, as, o, os, e, es
				} else {
					silabaTonica = silabaFinal;
					return silabaTonica.trim();
				}
			}
		}

		if (silabas.length == 1) {
			silabaTonica = silabas[0];
		}

		return silabaTonica.trim();
	}

	private boolean contemVogalAcentuada(String palavra) {
		List<String> vogaisAcentuadas = Arrays.asList(VOGAIS_ACENTUADAS);
		for (int i = 0; i < palavra.length(); i++) {
			String letra = "" + palavra.charAt(i);
			if (vogaisAcentuadas.contains(letra)) {
				return true;
			}
		}
		return false;
	}

	private boolean podeSerParoxitona(int qtdeSilabas) {
		return qtdeSilabas >= 2;
	}

}
