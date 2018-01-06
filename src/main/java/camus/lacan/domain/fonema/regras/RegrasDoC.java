package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

public class RegrasDoC {

	public String aplicarRegras(String string, String string2, String letraSeguinte) {
		if (Letras.A.equals(letraSeguinte) || Letras.O.equals(letraSeguinte) || Letras.U.equals(letraSeguinte)) {
			return Fonemas.K;
		}
		return Fonemas.S;
	}

}
