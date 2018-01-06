package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

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
