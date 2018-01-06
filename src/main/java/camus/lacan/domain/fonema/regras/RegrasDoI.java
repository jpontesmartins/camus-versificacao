package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

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
