package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoO  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letra) {
		if (posicao == 0) {
			return Fonemas.O;
		}
		String letraAnterior = palavra.charAt(posicao - 1) + "";

		if (Letras.H.equals(letraAnterior) && posicao - 1 == 0) {
			return Fonemas.O;
		}

		if (posicao == palavra.length() - 1 && Letras.isConsoante(letraAnterior)) {
			return Fonemas.U;
		}

		if (Letras.A_TIL.equals(letraAnterior) || posicao == palavra.length() - 1) {
			return Fonemas.W;
		}

		return Fonemas.O;
	}

}
