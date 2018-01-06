package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

public class RegrasDoE implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String string) {
		if (posicao <= palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			if (Letras.M.equals(letraSeguinte) || Letras.N.equals(letraSeguinte)) {
				return Fonemas.EN;
			}
		}
		return Fonemas.E;
	}

}
