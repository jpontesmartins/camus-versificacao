package camus.lacan.domain.separacao;

public class TratarEncontrosConsonantais {
	
	
	public static boolean isEncontroConsonantalTerminadoEmLOuR(char letra, char letraSeguinte) {
		return isConsoante(letra) && (letraSeguinte == 'l' || letraSeguinte == 'r');
	}
	
	public static boolean isEncontroConsonantalSeparavel(char letra, char letraSeguinte) {
		return !(isConsoante(letra) && TratarVogais.isVogal(letraSeguinte));
	}
	
	private static boolean isConsoante(char letra) {
		return !TratarVogais.isVogal(letra);
	}
}
