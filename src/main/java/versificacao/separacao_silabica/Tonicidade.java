package versificacao.separacao_silabica;

import java.util.Arrays;

public class Tonicidade {

	public String A = "a";
	public String O = "o";
	public String E = "e";
	public String AS = "as";
	public String OS = "os";
	public String ES = "es";
	public String S = "s";

	public String FINAIS_PAROXITONAS[] = { A, O, E, AS, OS, ES };

	public static void main(String[] args) {
		Tonicidade t = new Tonicidade();
		t.encontrarSilabaTonica("poema");
		t.encontrarSilabaTonica("cadeiras");
	}

	public String encontrarSilabaTonica(String palavra) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String silabas[] = separarPalavra.separar(palavra).split(" ");
		String silabaFinal = silabas[silabas.length - 1];
		String ultimaLetra = "" + silabaFinal.charAt(silabaFinal.length() - 1);
		int qtdeSilabas = silabas.length;
		String silabaTonica = "";
		String ultimasLetras = "";
		
		if (podeSerParoxitona(qtdeSilabas)) {
			if (ultimaLetra.equals(S) && silabaFinal.length() > 1) {
				ultimasLetras = silabaFinal.charAt(silabaFinal.length()-2) + "" + ultimaLetra;
			} else {
				ultimasLetras = ultimaLetra;
			}
			if (Arrays.asList(FINAIS_PAROXITONAS).contains(ultimasLetras)) {
				silabaTonica = silabas[qtdeSilabas - 2];
				return silabaTonica.trim(); //a, as, o, os, e, es
			} else {
				silabaTonica = silabaFinal;
				return silabaTonica.trim();
//				System.out.println("oxítona! " + palavra + " - ");
			}
		}
		
		

		return silabaTonica.trim();
	}

	private boolean podeSerParoxitona(int qtdeSilabas) {
		return qtdeSilabas >= 2;
	}

}
