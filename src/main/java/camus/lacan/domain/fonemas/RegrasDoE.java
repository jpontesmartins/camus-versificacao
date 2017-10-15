package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

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
