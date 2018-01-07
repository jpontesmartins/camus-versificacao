package camus.lacan.domain.separacao;

import java.util.Arrays;
import java.util.List;

import camus.lacan.comum.Letras;

public class TratarHiatos {
	
	public static boolean isHiato(char letra, char letraSeguinte, String palavra, int posicaoLetra) {
		String hiato = letra + "" + letraSeguinte;
		List<String> hiatos = Arrays.asList(Letras.HIATOS);

		boolean regrasDoU = false;
		if (Letras.U.equals(letra + "") && Letras.I.equals(letraSeguinte + "") && posicaoLetra + 2 < palavra.length()) {
			String ultimaLetra = "" + palavra.charAt(posicaoLetra + 2);
			String consoantesFinais[] = { Letras.Z, Letras.R, Letras.M };
			if (isUltimaLetra(palavra, posicaoLetra) && Arrays.asList(consoantesFinais).contains(ultimaLetra)) {
				regrasDoU = true;
			}
		}
		return hiatos.contains(hiato) || regrasDoU;
	}
	
	private static boolean isUltimaLetra(String palavra, int posicaoLetra) {
		return posicaoLetra + 2 == palavra.length() - 1;
	}

}
