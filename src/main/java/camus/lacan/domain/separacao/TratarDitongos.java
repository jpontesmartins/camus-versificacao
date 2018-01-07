package camus.lacan.domain.separacao;

public class TratarDitongos {
	
	public static boolean isDitongo(char letra, char letraSeguinte) {
		return TratarVogais.isVogal(letra) && TratarVogais.isVogal(letraSeguinte);
	}

}
