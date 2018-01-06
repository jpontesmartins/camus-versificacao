package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

public class RegrasDoR  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0)
			return Fonemas.R_MAISCULO;
		if (Letras.R.equals(letraSeguinte) || Letras.isConsoante(letraSeguinte)) {
			return Fonemas.R_MAISCULO;
		}
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.R.equals(letraAnterior)) {
			return "";
		}
		return Fonemas.R;
	}

}
