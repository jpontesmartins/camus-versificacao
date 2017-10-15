package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoI  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letra) {
		if (posicao == palavra.length() - 1) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior)) {
				return Fonemas.Y;
			}
		}
		return Fonemas.I;
	}

}
