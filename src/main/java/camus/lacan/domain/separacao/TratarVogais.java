package camus.lacan.domain.separacao;

import java.util.Arrays;
import java.util.List;

import camus.lacan.comum.Letras;

public class TratarVogais {
	
	public static boolean isVogal(char letra) {
		String letraComoString = ("" + letra).toLowerCase();
		List<String> vogais = Arrays.asList(Letras.VOGAIS);
		return (vogais.contains(letraComoString));
	}

}
