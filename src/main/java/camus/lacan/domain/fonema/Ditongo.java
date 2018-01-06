package camus.lacan.domain.fonema;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.comum.Letras;
import camus.lacan.domain.separacao.SepararPalavra;

public class Ditongo {

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
