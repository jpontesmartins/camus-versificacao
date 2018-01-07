package camus.lacan.domain.separacao;

import java.util.Arrays;
import java.util.List;

import camus.lacan.comum.Letras;

public class TratarDigrafos {

	public static boolean isDigrafoSeparavel(char letra, char letraSeguinte) {
		String encontroConsonantal = letra + "" + letraSeguinte;
		List<String> digrafos = Arrays.asList(Letras.DIGRAFOS_SEPARAVEIS);
		return (digrafos.contains(encontroConsonantal));
	}
	
	public static boolean isDigrafoInseparavel(char letra, char letraSeguinte) {
		String digrafo = letra + "" + letraSeguinte;
		List<String> digrafosInseparaveis = Arrays.asList(Letras.DIGRAFOS_INSEPARAVEIS);
		return (digrafosInseparaveis.contains(digrafo));
	}
}
