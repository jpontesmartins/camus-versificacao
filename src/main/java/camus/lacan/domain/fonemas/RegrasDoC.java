package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoC {

	public String aplicarRegras(String string, String string2, String letraSeguinte) {
		if (Letras.A.equals(letraSeguinte) || Letras.O.equals(letraSeguinte) || Letras.U.equals(letraSeguinte)) {
			return Fonemas.K;
		}
		return Fonemas.S;
	}

}
