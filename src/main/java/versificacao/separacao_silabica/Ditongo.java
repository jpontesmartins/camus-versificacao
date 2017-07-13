package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.List;

import versificacao.utils.Letras;

public class Ditongo {

	public static void main(String[] args) {
		Ditongo d = new Ditongo();
		d.pegarDitongos("quadrado");
		System.out.println("--");
	}

	public List<String> pegarDitongos(String palavra) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String palavraSeparada[] = separarPalavra.separar(palavra).split(" ");
		List<String> ditongosDaPalavra = new ArrayList<>();
		for (String silaba : palavraSeparada) {
			if (silaba.length() >= 2) {
				for (String ditongo : Letras.DITONGOS) {
					if (silaba.contains(ditongo)) {
						ditongosDaPalavra.add(silaba);
						System.out.println(silaba);
					}
				}
			}
		}
		return ditongosDaPalavra;
	}

}
