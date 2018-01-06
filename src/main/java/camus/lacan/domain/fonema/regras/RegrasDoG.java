package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

public class RegrasDoG implements Regras  {

	@Override
	public String aplicarRegras(String string, int i, String letraSeguinte) {
		if (Letras.U.equals(letraSeguinte)) {
			return Fonemas.G;
		} else if (Letras.isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.J;
		}
		return Fonemas.G;
	}

}
