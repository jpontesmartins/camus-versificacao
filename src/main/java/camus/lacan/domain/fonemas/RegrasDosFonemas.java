package camus.lacan.domain.fonemas;

public class RegrasDosFonemas {

	public static String regraDoA(String palavra, int posicao, String letra) {
		return new RegrasDoA().aplicarRegras(palavra, posicao, letra);
	}

	public static String regraDoE(String palavra, int posicao, String letra) {
		return new RegrasDoE().aplicarRegras(palavra, posicao, null);
	}

	public static String regrasDoM(String palavra, int posicao, String letraSeguinte) {
		return new RegrasDoM().aplicarRegras(palavra, posicao, letraSeguinte);
	}

	public static String regrasDoN(String palavra, int posicao, String letraSeguinte) {
		return new RegrasDoN().aplicarRegras(palavra, posicao, letraSeguinte);
	}

	public static String regrasDoS(int posicao, String letraSeguinte, String palavra) {
		return new RegrasDoS().aplicarRegras(palavra, posicao, letraSeguinte);
	}

	public static String regrasDoG(String letraSeguinte) {
		return new RegrasDoG().aplicarRegras("", 0, letraSeguinte);
	}

	public static String regrasDoR(int posicao, String letraSeguinte, String palavra) {
		return new RegrasDoR().aplicarRegras(palavra, posicao, letraSeguinte);
	}
	public static String regrasDoC(String letraSeguinte) {
		return new RegrasDoC().aplicarRegras("", "", letraSeguinte);
	}

	public static String regrasDoU(String letra, String palavra, int posicao) {
		return new RegrasDoU().aplicarRegras(palavra, posicao, letra);
	}

	public static String regrasDoI(String palavra, int posicao, String letra) {
		return new RegrasDoI().aplicarRegras(palavra, posicao, letra);
	}

	public static String regraDeO(String palavra, int posicao, String letra) {
		return new RegrasDoO().aplicarRegras(palavra, posicao, letra);
	}
}
