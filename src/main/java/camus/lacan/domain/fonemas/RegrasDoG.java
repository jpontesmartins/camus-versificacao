package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

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
