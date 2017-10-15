package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoA implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letra) {
		if (Letras.A_TIL.equals(letra))
			return Fonemas.AN;

		if (posicao < palavra.length() - 2) {
			String letraSeguinte = palavra.charAt(posicao + 1) + "";
			String letraAposM = palavra.charAt(posicao + 2) + "";
			if (Letras.M.equals(letraSeguinte) && !Letras.isVogal(letraAposM)) {
				return Fonemas.AN;
			}
		}
		return Fonemas.A;
	}

}
